package com.example.devopsexampractical.v1.serviceImpl;

import com.example.devopsexampractical.v1.exceptions.InvalidOperationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MathOperatorImplTest {

    int operand1;
    int operand2;
    String operation;
    double result;
    MathOperatorImpl mathOperator = new MathOperatorImpl();

    @Test
    public void doMathsAddition() throws InvalidOperationException {
        operand1 = 10;
        operand2 = 20;
        operation = "+";
        result = mathOperator.doMath(operand1, operand2, operation);
        assertEquals(30, result);
    }
    @Test
    public void doMathsSubtraction() throws InvalidOperationException {
        operand1 = 10;
        operand2 = 20;
        operation = "-";
        result = mathOperator.doMath(operand1, operand2, operation);
        assertEquals(-10, result);
    }
    @Test
    public void doMathsMultiplication() throws InvalidOperationException {
        operand1 = 10;
        operand2 = 20;
        operation = "*";
        result = mathOperator.doMath(operand1, operand2, operation);
        assertEquals(200, result);
    }
    @Test
    public void doMathsDivision() throws InvalidOperationException {
        operand1 = 20;
        operand2 = 10;
        operation = "/";
        result = mathOperator.doMath(operand1, operand2, operation);
        assertEquals(2, result);
    }
    @Test
    public void doMathsDivisionWithZero() throws InvalidOperationException {
        operand1 = 20;
        operand2 = 0;
        operation = "/";
        // here it throws an exception
        assertThrows(InvalidOperationException.class, () -> {
            result = mathOperator.doMath(operand1, operand2, operation);
            ;
        });
    }

    @Test
    public void doMathsInvalidOrNoOperand(){
        operand1 = 20;
        operand2 = 0;
        operation = "";
        // here it throws an exception
        assertThrows(RuntimeException.class, () -> {
            result = mathOperator.doMath(operand1, operand2, operation);
            ;
        });
    }
    @Test
    public void doMathsMultiplyByOne() throws InvalidOperationException {
        operand1 = 20;
        operand2 = 1;
        operation = "*";
        result = mathOperator.doMath(operand1, operand2, operation);
        assertEquals(20, result);
    }

    @Test
    public void doMathsMultiplyByZero() throws InvalidOperationException {
        operand1 = 20;
        operand2 = 0;
        operation = "*";
        result = mathOperator.doMath(operand1, operand2, operation);
        assertEquals(0, result);
    }

    @Test
    public void doMathsAdditionWithNegative() throws InvalidOperationException {
        operand1 = -20;
        operand2 = 10;
        operation = "+";
        result = mathOperator.doMath(operand1, operand2, operation);
        assertEquals(-10, result);
    }

    @Test
    public void doMathsSubtractionWithNegative() throws InvalidOperationException {
        operand1 = -20;
        operand2 = 10;
        operation = "-";
        result = mathOperator.doMath(operand1, operand2, operation);
        assertEquals(-30, result);
    }
}