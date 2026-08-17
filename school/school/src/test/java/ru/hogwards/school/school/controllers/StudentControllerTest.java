package ru.hogwards.school.school.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import ru.hogwards.school.school.constants.ConstantFacultyTest;
import ru.hogwards.school.school.constants.ConstantStudentTest;
import ru.hogwards.school.school.exceptions.HogwardsConstantException;
import ru.hogwards.school.school.exceptions.NotFoundStudentException;
import ru.hogwards.school.school.models.Faculty;
import ru.hogwards.school.school.models.Student;
import ru.hogwards.school.school.repositories.StudentRepository;
import ru.hogwards.school.school.services.StudentServiceImpl;

import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private StudentRepository repository;

    @MockitoSpyBean
    private StudentServiceImpl service;

    @InjectMocks
    private StudentController controller;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        ConstantStudentTest.STUDENT_1.setName(ConstantStudentTest.NAME_1);
        ConstantStudentTest.STUDENT_1.setAge(ConstantStudentTest.AGE_1);
        ConstantStudentTest.STUDENT_1.setId(ConstantStudentTest.ID_1);

        ConstantStudentTest.STUDENT_2.setName(ConstantStudentTest.NAME_2);
        ConstantStudentTest.STUDENT_2.setAge(ConstantStudentTest.AGE_2);
        ConstantStudentTest.STUDENT_2.setId(ConstantStudentTest.ID_2);

        ConstantStudentTest.STUDENT_3.setName(ConstantStudentTest.NAME_3);
        ConstantStudentTest.STUDENT_3.setAge(ConstantStudentTest.AGE_3);
        ConstantStudentTest.STUDENT_3.setId(ConstantStudentTest.ID_3);

        ConstantStudentTest.STUDENT_4.setName(ConstantStudentTest.NAME_4);
        ConstantStudentTest.STUDENT_4.setAge(ConstantStudentTest.AGE_4);
        ConstantStudentTest.STUDENT_4.setId(ConstantStudentTest.ID_4);

        when(repository.save(any(Student.class))).thenReturn(ConstantStudentTest.STUDENT_1);
        when(repository.findById(any(Long.class))).thenReturn(Optional.ofNullable(ConstantStudentTest.STUDENT_1));
        when(repository.findAll()).thenReturn(ConstantStudentTest.ALL_STUDENTS);
        when(repository.existsById(ConstantStudentTest.ID_1)).thenReturn(true);
        doNothing().when(repository).deleteById(anyLong());
        when(repository.findByAgeBetween(ConstantStudentTest.MIN, ConstantStudentTest.MAX)).thenReturn(ConstantStudentTest.STUDENTS_AGE_BETWEEN);
    }

    @Test
    void saveTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ConstantStudentTest.OBJECT.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ConstantStudentTest.ID_1))
                .andExpect(jsonPath("$.name").value(ConstantStudentTest.NAME_1))
                .andExpect(jsonPath("$.age").value(ConstantStudentTest.AGE_1));
    }

    @Test
    void getByIdTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students/" + ConstantStudentTest.ID_1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ConstantStudentTest.ID_1))
                .andExpect(jsonPath("$.name").value(ConstantStudentTest.NAME_1))
                .andExpect(jsonPath("$.age").value(ConstantStudentTest.AGE_1));
    }

    @Test
    void getByIdNegativeTest() throws  Exception {
        when(repository.findById(ConstantStudentTest.NOT_EXIST_ID)).thenReturn(Optional.empty());

        mockMvc.perform(MockMvcRequestBuilders.get("/students/" + ConstantStudentTest.NOT_EXIST_ID)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void getByAgeBetweenTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(
                                "/students/getByAgeBetween?min={min}&max={max}",
                                ConstantStudentTest.MIN,
                                ConstantStudentTest.MAX)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(ConstantStudentTest.ID_3))
                .andExpect(jsonPath("$[0].name").value(ConstantStudentTest.NAME_3))
                .andExpect(jsonPath("$[0].age").value(ConstantStudentTest.AGE_3))
                .andExpect(jsonPath("$[1].id").value(ConstantStudentTest.ID_4))
                .andExpect(jsonPath("$[1].name").value(ConstantStudentTest.NAME_4))
                .andExpect(jsonPath("$[1].age").value(ConstantStudentTest.AGE_4));
    }

    @Test
    void deleteTest() throws Exception {
        when(repository.existsById(ConstantStudentTest.ID_1)).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.delete("/students/{id}", ConstantStudentTest.ID_1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ConstantStudentTest.ID_1))
                .andDo(MockMvcResultHandlers.print());
        verify(repository, times(1)).deleteById(ConstantStudentTest.ID_1);
    }

    @Test
    void deleteNegativeTest() throws  Exception {
        when(repository.findById(ConstantStudentTest.NOT_EXIST_ID)).thenReturn(Optional.empty());

        mockMvc.perform(MockMvcRequestBuilders.delete("/students/" + ConstantStudentTest.NOT_EXIST_ID)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void getAllTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[?(@.id == " + ConstantStudentTest.ID_1 + ")]").exists())
                .andExpect(jsonPath("$[?(@.id == " + ConstantStudentTest.ID_1 + ")].name").value(ConstantStudentTest.NAME_1))
                .andExpect(jsonPath("$[?(@.id == " + ConstantStudentTest.ID_2 + ")]").exists())
                .andExpect(jsonPath("$[?(@.id == " + ConstantStudentTest.ID_2 + ")].age").value(ConstantStudentTest.AGE_2));
    }

    @Test
    void editTest() throws Exception {
        Integer newAge = 45;
        Student studentUpdate = ConstantStudentTest.STUDENT_1;
        studentUpdate.setAge(newAge);
        when(repository.save(any(Student.class))).thenReturn(studentUpdate);

        mockMvc.perform(
                        MockMvcRequestBuilders.put("/students")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(studentUpdate)))
                .andDo(MockMvcResultHandlers.print()) // Выведет тело запроса и ответа в консоль для отладки
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.age").value(newAge));
    }

    @Test
    void editNegativeTest() throws Exception {
        Integer newAge = 45;
        Student studentUpdate = ConstantStudentTest.STUDENT_1;
        studentUpdate.setAge(newAge);

        doThrow(new NotFoundStudentException(HogwardsConstantException.NOT_FOUND_STUDENT))
                .when(service).change(any(Student.class));


        mockMvc.perform(
                        MockMvcRequestBuilders.put("/students")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(studentUpdate)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }

    @Test
    void getFacultyTest() throws Exception {
        when(repository.findById(ConstantStudentTest.ID_1)).thenReturn(Optional.ofNullable(ConstantStudentTest.STUDENT_1));
        ConstantStudentTest.STUDENT_1.setFaculty(ConstantFacultyTest.FACULTY_1);

        mockMvc.perform(MockMvcRequestBuilders.get("/students/" + ConstantStudentTest.ID_1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ConstantStudentTest.STUDENT_1)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.faculty").value(ConstantFacultyTest.FACULTY_1));
    }

    @Test
    void getFacultyNegativeTest() throws Exception {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        mockMvc.perform(MockMvcRequestBuilders.get("/students/" + ConstantStudentTest.ID_1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string(""));
    }
}
