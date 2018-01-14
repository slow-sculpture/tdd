package pl.sda.poznan.exercises;

public class Factorial {
    //zeby  nie mozna bylo stworzyc obiektu tej klasy
    private Factorial() {
        throw new IllegalStateException("Utility class");
    }

    public static int factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }

      /*  silnia obliczona jak kiedys
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;*/

        //silnia obliczona rekursywnie
        if (number == 0 || number == 1) {
            return 1;
        }
        return factorial(number - 1) * number;
    }
}
