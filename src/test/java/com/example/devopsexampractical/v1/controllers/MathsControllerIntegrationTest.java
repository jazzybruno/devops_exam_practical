package com.example.devopsexampractical.v1.controllers;

import com.example.devopsexampractical.v1.dtos.requests.DoMathRequest;
import com.example.devopsexampractical.v1.dtos.responses.CalcResponse;
import com.example.devopsexampractical.v1.utils.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class MathsControllerIntegrationTest {

    private static RestTemplate restTemplate;
    private static ObjectMapper objectMapper;

    @LocalServerPort
    private int port = 5000;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
    }


    @Test
    public void testAdd() {
        DoMathRequest newItem = new DoMathRequest(1, 2, "+");
        ResponseEntity<CalcResponse> response = restTemplate
                .exchange("http://localhost:5000/api/calc/do-maths",
                        HttpMethod.POST,
                        TestUtils.createHttpEntity(newItem),
                        CalcResponse.class);

        assertNotNull(response.getBody());
        assertEquals(3, response.getBody().getCalcResponse());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testSubtract() {
        DoMathRequest newItem = new DoMathRequest(1, 2, "-");
        ResponseEntity<CalcResponse> response = restTemplate
                .exchange("http://localhost:5000/api/calc/do-maths",
                        HttpMethod.POST,
                        TestUtils.createHttpEntity(newItem),
                        CalcResponse.class);

        assertNotNull(response.getBody());
        assertEquals(-1, response.getBody().getCalcResponse());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testMultiply() {
        DoMathRequest newItem = new DoMathRequest(1, 2, "*");
        ResponseEntity<CalcResponse> response = restTemplate
                .exchange("http://localhost:5000/api/calc/do-maths",
                        HttpMethod.POST,
                        TestUtils.createHttpEntity(newItem),
                        CalcResponse.class);

        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().getCalcResponse());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testDivide() {
        DoMathRequest newItem = new DoMathRequest(6, 2, "/");
        ResponseEntity<CalcResponse> response = restTemplate
                .exchange("http://localhost:5000/api/calc/do-maths",
                        HttpMethod.POST,
                        TestUtils.createHttpEntity(newItem),
                        CalcResponse.class);

        assertNotNull(response.getBody());
        assertEquals(3, response.getBody().getCalcResponse());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}