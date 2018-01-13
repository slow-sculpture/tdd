package pl.sda.poznan.exercises;

public class Greetings {
    public static String greet(String... names) {

        if (names == null) {
            return "Hello, my friend";
        }
        if (names.length == 1) {
            String name = names[0];
            //czy imie rowna sie temu samemu znakowi zapisanego wielkimi literami
            if (name.equals(name.toUpperCase())) {
                return String.format("HELLO, %s", names);
            }
            return String.format("Hello, %s", names);
        } else {
            return String.format("Hello, %s and %s", names[0], names[1]);
        }

    }
}


//      varargs pozwala przekazac do funkcji wiele parametrow roznego typu
//     przy argumencie wpisujemy:  ...  -> tablica []
//     jezeli funkcja ma wiecej niz jeden parametr do varargs musi byc jako ostatnie wpisane