package ru.hogwards.school.school.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.hogwards.school.school.services.InfoServiceImpl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class InfoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoSpyBean
    private InfoServiceImpl service;

    @InjectMocks
    private InfoController controller;

    @Test void shouldReturnPortFromPropertiesFile() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/port"))
                .andExpect(status().isOk())
                .andExpect(content().string("server.port=" + 2066));
    }
}

