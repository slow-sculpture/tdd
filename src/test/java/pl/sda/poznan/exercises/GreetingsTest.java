package pl.sda.poznan.exercises;

import org.junit.Test;
import pl.sda.poznan.exercises.Greetings;

import static org.junit.Assert.*;

public class GreetingsTest {

    @Test
    public void should_greet_single_name(){
        String name = Greetings.greet("Jan");
        assertEquals("Hello, Jan", name);
    }
    @Test
    public void should_greet_as_a_firend_when_null_passed(){
        String greet = Greetings.greet(null);
        assertEquals("Hello, my friend", greet);
    }
    @Test
    public void should_return_greet_in_capital_letters(){
        String greet = Greetings.greet("JAN");
        assertEquals("HELLO, JAN", greet);
    }
    @Test
    public void should_greet_two_people(){
        String greet = Greetings.greet("Jan", "Ala");
        assertEquals("Hello, Jan and Ala", greet);
    }
    @Test
    public void should_greet_many_people(){
        String greet = Greetings.greet("Jan", "Ala", "Bob");
        assertEquals("Hello, Jan, Ala and Bob", greet);
    }
    @Test
    public void should_greet_with_capital_letters(){
        String greet = Greetings.greet("Jan", "ALA", "Bob");
        assertEquals("Hello, Jan and Bob AND HELLO ALA", greet);
    }



}