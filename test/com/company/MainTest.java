package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.company.Main.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMakeOperationAdd() {
        double result = makeOperation("add", 1, 1);
        assertEquals(2, result);
    }

    @Test
    void testMakeOperationDivide() {
        double result = makeOperation("divide", 3, 9);
        assertEquals(3, result);
    }

    @Test
    void testMakeOperationSubtract() {
        double result = makeOperation("subtract", 8, 9);
        assertEquals(1, result);
    }

    @Test
    void testMakeOperationMultiply() {
        double result = makeOperation("multiply", 4, 3);
        assertEquals(12, result);
    }

    @Test
    void testReadFile1() {
        List<String> linesFromFile = readFile("input_example_1");
        List<String> linesExpected = new ArrayList<>(Arrays.asList("add 2","multiply 3","divide 4" ,"apply 4"));

        assertEquals(linesExpected, linesFromFile);
    }

    @Test
    void testReadFile2() {
        List<String> linesFromFile = readFile("input_example_2");
        List<String> linesExpected = new ArrayList<>(Arrays.asList("multiply 9", "apply 5"));

        assertEquals(linesExpected, linesFromFile);
    }

    @Test
    void testReadFile3() {
        List<String> linesFromFile = readFile("input_example_3");
        List<String> linesExpected = new ArrayList<>(Arrays.asList("apply 1"));

        assertEquals(linesExpected, linesFromFile);
    }

    @Test
    void testGetInitValueFromList() {
        List<String> lines = new ArrayList<>(Arrays.asList("multiply 9","apply 1"));
        double result = getInitValueFromLines(lines);
        assertEquals(1, result);
    }

    @Test
    void testCalculatorWithFile1() {
        double result = calculateResultFromFile("input_example_1");
        assertEquals(4.5, result);
    }

    @Test
    void testCalculatorWithFile2() {
        double result = calculateResultFromFile("input_example_2");
        assertEquals(45, result);
    }

    @Test
    void testCalculatorWithFile3() {
        double result = calculateResultFromFile("input_example_3");
        assertEquals(1, result);
    }

}