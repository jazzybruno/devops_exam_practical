package com.example.devopsexampractical.v1.controllers;


import com.example.devopsexampractical.v1.dtos.requests.DoMathRequest;
import com.example.devopsexampractical.v1.dtos.responses.CalcResponse;
import com.example.devopsexampractical.v1.exceptions.InvalidOperationException;
import com.example.devopsexampractical.v1.services.MathOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/calc")
public class MathsController {

    private final MathOperator mathOperator;

    @Autowired
    public MathsController(MathOperator mathOperator) {
        this.mathOperator = mathOperator;
    }

    @PostMapping("/do-maths")
    public ResponseEntity<CalcResponse> doMath(@RequestBody DoMathRequest doMathRequest) {
        try {
            Double result = mathOperator.doMath(doMathRequest.getOperand1(), doMathRequest.getOperand2(), doMathRequest.getOperation());
            CalcResponse calcResponse = new CalcResponse(result);
            return ResponseEntity.ok(calcResponse);
        } catch (InvalidOperationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
