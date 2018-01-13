package pl.sda.poznan.exercises;

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

    @Test
    public void should_sum_two_number(){
        int result = Calculator.sum("2,3");
        assertEquals(result, 5);
    }

    @Test
    public void should_sum_multiple_nimbers(){
        int sum = Calculator.sum("2,3,4,5");
        assertEquals(14, sum);
    }

    @Test
    public void should_sum_number_separated_by_new_line_mark(){
        int sum = Calculator.sum("2\n3\n1");
        assertEquals(6, sum);
    }

}