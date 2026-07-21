package com.trekExpert.expertguide.controller;

import com.trekExpert.expertguide.model.Expert;
import com.trekExpert.expertguide.service.ExpertService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ExpertControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExpertService expertService;

    @Autowired
    private ObjectMapper objectMapper;

    private Expert testExpert;

    @BeforeEach
    public void setUp() {
        testExpert = new Expert();
        testExpert.setId(1L);
        testExpert.setName("John Doe");
        testExpert.setEmail("john@example.com");
        testExpert.setExpertise("Java");
        testExpert.setBio("Experienced Java developer");
        testExpert.setYearsExperience(10);
        testExpert.setIsActive(true);
    }

    @Test
    public void testGetAllExperts() throws Exception {
        when(expertService.getAllExperts()).thenReturn(Arrays.asList(testExpert));

        mockMvc.perform(get("/experts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Doe"));
    }

    @Test
    public void testGetExpertById() throws Exception {
        when(expertService.getExpertById(1L)).thenReturn(Optional.of(testExpert));

        mockMvc.perform(get("/experts/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("john@example.com"));
    }

    @Test
    public void testCreateExpert() throws Exception {
        when(expertService.createExpert(any(Expert.class))).thenReturn(testExpert);

        mockMvc.perform(post("/experts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testExpert)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void testUpdateExpert() throws Exception {
        when(expertService.updateExpert(eq(1L), any(Expert.class))).thenReturn(testExpert);

        mockMvc.perform(put("/experts/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testExpert)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));
    }

    @Test
    public void testDeleteExpert() throws Exception {
        when(expertService.deleteExpert(1L)).thenReturn(true);

        mockMvc.perform(delete("/experts/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
