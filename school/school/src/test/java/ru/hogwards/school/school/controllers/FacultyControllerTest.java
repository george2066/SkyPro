package ru.hogwards.school.school.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import ru.hogwards.school.school.models.Faculty;
import ru.hogwards.school.school.repositories.FacultyRepository;
import ru.hogwards.school.school.services.FacultyServiceImpl;

import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FacultyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private FacultyRepository repository;

    @MockitoSpyBean
    private FacultyServiceImpl service;

    @InjectMocks
    private FacultyController controller;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();

        ConstantFacultyTest.FACULTY_1.setId(ConstantFacultyTest.ID_1);
        ConstantFacultyTest.FACULTY_1.setName(ConstantFacultyTest.NAME_1);
        ConstantFacultyTest.FACULTY_1.setColor(ConstantFacultyTest.COLOR_1);

        ConstantFacultyTest.FACULTY_2.setId(ConstantFacultyTest.ID_2);
        ConstantFacultyTest.FACULTY_2.setName(ConstantFacultyTest.NAME_2);
        ConstantFacultyTest.FACULTY_2.setColor(ConstantFacultyTest.COLOR_2);

        ConstantFacultyTest.FACULTY_3.setId(ConstantFacultyTest.ID_3);
        ConstantFacultyTest.FACULTY_3.setName(ConstantFacultyTest.NAME_3);
        ConstantFacultyTest.FACULTY_3.setColor(ConstantFacultyTest.COLOR_3);

        ConstantFacultyTest.FACULTY_4.setId(ConstantFacultyTest.ID_4);
        ConstantFacultyTest.FACULTY_4.setName(ConstantFacultyTest.NAME_4);
        ConstantFacultyTest.FACULTY_4.setColor(ConstantFacultyTest.COLOR_4);

        ConstantStudentTest.STUDENT_1.setFaculty(ConstantFacultyTest.FACULTY_1);
        ConstantStudentTest.STUDENT_2.setFaculty(ConstantFacultyTest.FACULTY_1);
        ConstantStudentTest.STUDENT_3.setFaculty(ConstantFacultyTest.FACULTY_1);
        ConstantStudentTest.STUDENT_4.setFaculty(ConstantFacultyTest.FACULTY_1);

        when(repository.save(any(Faculty.class))).thenReturn(ConstantFacultyTest.FACULTY_1);
        when(repository.findById(any(Long.class))).thenReturn(Optional.of(ConstantFacultyTest.FACULTY_1));
        when(repository.existsById(ConstantStudentTest.ID_1)).thenReturn(true);
        when(repository.findAll()).thenReturn(ConstantFacultyTest.ALL_FACULTIES);
        when(repository.findByColorIgnoreCase(anyString())).thenReturn(ConstantFacultyTest.FACULTY_1);
    }

    @Test
    void saveTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/faculties")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ConstantFacultyTest.OBJECT.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(ConstantFacultyTest.NAME_1));
    }

    @Test
    void getByIdTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/faculties/" + ConstantFacultyTest.ID_1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ConstantFacultyTest.ID_1))
                .andExpect(jsonPath("$.name").value(ConstantFacultyTest.NAME_1))
                .andExpect(jsonPath("$.color").value(ConstantFacultyTest.COLOR_1));
    }

    @Test
    void deleteTest() throws Exception {
        when(repository.existsById(ConstantFacultyTest.ID_1)).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.delete("/faculties/{id}", ConstantFacultyTest.ID_1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ConstantFacultyTest.ID_1))
                .andDo(MockMvcResultHandlers.print());
        verify(repository, times(1)).deleteById(ConstantFacultyTest.ID_1);
    }

    @Test
    void getAllTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/faculties")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[?(@.id == " + ConstantFacultyTest.ID_1 + ")]").exists())
                .andExpect(jsonPath("$[?(@.id == " + ConstantFacultyTest.ID_1 + ")].name").value(ConstantFacultyTest.NAME_1))
                .andExpect(jsonPath("$[?(@.id == " + ConstantFacultyTest.ID_2 + ")]").exists())
                .andExpect(jsonPath("$[?(@.id == " + ConstantFacultyTest.ID_2 + ")].color").value(ConstantFacultyTest.COLOR_2));
    }

    @Test
    void editTest() throws Exception {
        String newColor = "new_color";
        Faculty faculty = ConstantFacultyTest.FACULTY_1;
        faculty.setColor(newColor);

        mockMvc.perform(MockMvcRequestBuilders.put("/faculties/{id}", faculty.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(faculty)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.color").value(newColor));
    }

    @Test
    void getStudentsTest() throws  Exception {
        when(repository.findById(anyLong())).thenReturn(Optional.of(ConstantFacultyTest.FACULTY_1));
        when(repository.existsById(anyLong())).thenReturn(true);
        when(service.getStudents(anyLong())).thenReturn(ConstantFacultyTest.ALL_STUDENTS);

        mockMvc.perform(MockMvcRequestBuilders.get("/faculties/getStudents/" + ConstantFacultyTest.ID_1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void getByName() throws Exception {
        when(service.getByColorOrName(null, ConstantFacultyTest.NAME_1)).thenReturn(ConstantFacultyTest.FACULTY_1);

        mockMvc.perform(MockMvcRequestBuilders.get("/faculties/getByColorOrName")
                        .param("name", ConstantFacultyTest.NAME_1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(service, times(1)).getByColorOrName(null, ConstantFacultyTest.NAME_1);
    }

    @Test
    void getByColor() throws Exception {
        when(service.getByColorOrName(ConstantFacultyTest.COLOR_1, null)).thenReturn(ConstantFacultyTest.FACULTY_1);

        mockMvc.perform(MockMvcRequestBuilders.get("/faculties/getByColorOrName")
                        .param("color", ConstantFacultyTest.COLOR_1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(service, times(1)).getByColorOrName(ConstantFacultyTest.COLOR_1, null);
    }
}
