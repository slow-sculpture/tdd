package pl.sda.poznan.exercises;

public class IsPrimeNumber {
    public static boolean isPrime(int number) {
        // return false;
        boolean result = true;
        for (int i = 2; i <= number/2; i++) {
            if (number % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}

