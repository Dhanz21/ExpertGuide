package com.trekExpert.expertguide.controller;

import com.trekExpert.expertguide.dto.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CustomerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String url(String path) {
        return "http://localhost:" + port + path;
    }

    @Test
    public void createAndGetCustomer() {
        CustomerDto req = new CustomerDto(null, "John Doe", "john@example.com", true, "SW1A 1AA");

        ResponseEntity<CustomerDto> post = restTemplate.postForEntity(url("/api/customers"), req, CustomerDto.class);
        assertEquals(HttpStatus.CREATED, post.getStatusCode());

        CustomerDto created = post.getBody();
        assertNotNull(created);
        assertNotNull(created.id());
        assertEquals("john@example.com", created.email());
        assertTrue(created.isPreviliged());
        assertEquals("SW1A 1AA", created.postcode());

        ResponseEntity<CustomerDto> get = restTemplate.getForEntity(url("/api/customers/" + created.id()), CustomerDto.class);
        assertEquals(HttpStatus.OK, get.getStatusCode());
        assertEquals("John Doe", get.getBody().name());
        assertEquals("john@example.com", get.getBody().email());
    }
}
