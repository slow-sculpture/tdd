package pl.sda.poznan.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void should_return_zero_when_empty_string(){
        int sum = Calculator.sum("");
        assertEquals(0,sum);
    }

    @Test
    public void should_return_number_when_one_number_is_given(){
        int number = Calculator.sum("2");
        assertEquals(number, 2);
    }

}