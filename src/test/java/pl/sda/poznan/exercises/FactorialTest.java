package pl.sda.poznan.exercises;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FactorialTest {

    private int number;
    private int factorial;

    public FactorialTest(int number, int factorial) {
        this.number = number;
        this.factorial = factorial;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120},
        });
    }

    @Test
    public void gives_factiorial() {
        assertEquals(Factorial.factorial(number), factorial);
    }



    @Test (expected = IllegalArgumentException.class)
    public void should_throw_exception_if_number_is_minus(){
        int result = Factorial.factorial(-2);
        assertEquals(new IllegalArgumentException(), result);

    }



}