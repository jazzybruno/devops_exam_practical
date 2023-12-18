package com.example.devopsexampractical.v1.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoMathRequest {
    private double operand1;
    private double operand2;
    private String operation;
}
