package com.example.devopsexampractical.v1.services;

import com.example.devopsexampractical.v1.exceptions.InvalidOperationException;

public interface MathOperator {
    double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}

