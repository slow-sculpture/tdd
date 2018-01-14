package pl.sda.poznan.exercises;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class PeselValidatorTest {

    private String number;
    private boolean isValid;

    public PeselValidatorTest(String number, boolean isValid) {
        this.number = number;
        this.isValid = isValid;
    }

    @Parameterized.Parameters
    public static Collection<Object[]>data(){
        return Arrays.asList(new Object[][]{
            {"86060917157", true},
            {"05270705156", true},
            //{"05270705152", false},
        });
    }

    @Test
    public void should_validate_pesel(){
        //AAA
        //Arrange
        PeselValidator validator = new PeselValidator();
        //Act
        boolean validResult = validator.validate(this.number);
        //Assert
        assertEquals(this.isValid, validResult);

    }



}