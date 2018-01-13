package pl.sda.poznan.exercises;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IsPrimeNumberTest {

    private int number;
    private boolean isPrime;

    //konstruktor dla ww. pol
    public IsPrimeNumberTest(int number, boolean isPrime) {
        this.number = number;
        this.isPrime = isPrime;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, true},
                {3, true},
                {4, false},
                {5, true},
                {6, false},
                {7, true},
        });
    }


    @Test
    public void isPrime() {
        assertEquals(IsPrimeNumber.isPrime(number), isPrime);
    }


    //zamiast wywolywac test dla kazdej wartosci j.n.
    //mozna przekazac do testowania caly zbior j.w.
    //  -> resty parametryzowane

/*
    @Test
    public void should_return_true_if_its_prime() {
        boolean prime = IsPrimeNumber.isPrime(3);
        assertEquals(true, prime);

        boolean notPrime = IsPrimeNumber.isPrime(6);
        assertEquals(false, notPrime);
    }*/


}