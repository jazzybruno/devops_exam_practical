package com.example.devopsexampractical.v1.controllers;

import com.example.devopsexampractical.v1.dtos.requests.DoMathRequest;
import com.example.devopsexampractical.v1.dtos.responses.CalcResponse;
import com.example.devopsexampractical.v1.services.MathOperator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockHttpServletRequestDsl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc class MathsControllerIntegrationTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MathOperator mathOperator;

    @Test
    public void testAdd() throws Exception {
        DoMathRequest doMathRequest = new DoMathRequest(5 , 4 , "+");
        Double mockedresult = 9.0;
        when(mathOperator.doMath(doMathRequest.getOperand1() , doMathRequest.getOperand2() , doMathRequest.getOperation())).thenReturn(mockedresult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/calc/do-maths")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(doMathRequest));

        mockMvc.perform(requestBuilder).andExpect(
                result -> {
                    CalcResponse calcResponse = objectMapper.readValue(result.getResponse().getContentAsString() , CalcResponse.class);
                    System.out.println(calcResponse.getCalcResponse());
                    assert calcResponse.getCalcResponse() == mockedresult;
                }
        )
                .andExpect(
                        result -> {
                            assert result.getResponse().getStatus() == 200;
                        }
                );
    }

    @Test
    public void testSubtract() throws Exception {
        DoMathRequest doMathRequest = new DoMathRequest(5 , 4 , "-");
        Double mockedresult = 1.0;
        when(mathOperator.doMath(doMathRequest.getOperand1() , doMathRequest.getOperand2() , doMathRequest.getOperation())).thenReturn(mockedresult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/calc/do-maths")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(doMathRequest));

        mockMvc.perform(requestBuilder).andExpect(
                        result -> {
                            CalcResponse calcResponse = objectMapper.readValue(result.getResponse().getContentAsString() , CalcResponse.class);
                            System.out.println(calcResponse.getCalcResponse());
                            assert calcResponse.getCalcResponse() == mockedresult;
                        }
                )
                .andExpect(
                        result -> {
                            assert result.getResponse().getStatus() == 200;
                        }
                );
    }

    @Test
    public void testMultiply() throws Exception {
        DoMathRequest doMathRequest = new DoMathRequest(5 , 4 , "*");
        Double mockedresult = 20.0;
        when(mathOperator.doMath(doMathRequest.getOperand1() , doMathRequest.getOperand2() , doMathRequest.getOperation())).thenReturn(mockedresult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/calc/do-maths")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(doMathRequest));

        mockMvc.perform(requestBuilder).andExpect(
                        result -> {
                            CalcResponse calcResponse = objectMapper.readValue(result.getResponse().getContentAsString() , CalcResponse.class);
                            System.out.println(calcResponse.getCalcResponse());
                            assert calcResponse.getCalcResponse() == mockedresult;
                        }
                )
                .andExpect(
                        result -> {
                            assert result.getResponse().getStatus() == 200;
                        }
                );
    }

    @Test
    public void testDivide() throws Exception {
        DoMathRequest doMathRequest = new DoMathRequest(5 , 5 , "/");
        Double mockedresult = 1.0;
        when(mathOperator.doMath(doMathRequest.getOperand1() , doMathRequest.getOperand2() , doMathRequest.getOperation())).thenReturn(mockedresult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/calc/do-maths")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(doMathRequest));

        mockMvc.perform(requestBuilder).andExpect(
                        result -> {
                            CalcResponse calcResponse = objectMapper.readValue(result.getResponse().getContentAsString() , CalcResponse.class);
                            System.out.println(calcResponse.getCalcResponse());
                            assert calcResponse.getCalcResponse() == mockedresult;
                        }
                )
                .andExpect(
                        result -> {
                            assert result.getResponse().getStatus() == 200;
                        }
                );
    }


}