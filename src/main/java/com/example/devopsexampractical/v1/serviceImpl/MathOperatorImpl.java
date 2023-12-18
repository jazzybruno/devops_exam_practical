package com.example.devopsexampractical.v1.serviceImpl;

import com.example.devopsexampractical.v1.exceptions.InvalidOperationException;
import com.example.devopsexampractical.v1.services.MathOperator;

public class MathOperatorImpl implements MathOperator {
    @Override
    public double doMath(double operand1, double operand2, String
            operation) throws InvalidOperationException{
        if ("/".equals(operation) && operand2 == (double) 0) {
            throw new InvalidOperationException("Cannot divide by 0");
        }
        switch (operation) {
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            default:
                throw new RuntimeException("Unknown operation");
        }
    }
}
