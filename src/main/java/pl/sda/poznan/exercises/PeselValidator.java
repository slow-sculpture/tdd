package pl.sda.poznan.exercises;

public class PeselValidator {
    public boolean validate(String id) {
        int result = calculateControlSum(id);
        return checkControlSum(result, convertCharToInt(id.charAt(10)));

    }
    private int convertCharToInt(char c){
        return Integer.parseInt(String.valueOf(c));
    }

    private boolean checkControlSum(int sumToCheck, int validSum){
        int modulo = sumToCheck % 10;
        return modulo == validSum;
    }

    private int calculateControlSum(String id){
        return 9 * convertCharToInt(id.charAt(0)) +
                7 * convertCharToInt(id.charAt(1)) +
                3 * convertCharToInt(id.charAt(2)) +
                1 * convertCharToInt(id.charAt(3)) +
                9 * convertCharToInt(id.charAt(4)) +
                7 * convertCharToInt(id.charAt(5)) +
                3 * convertCharToInt(id.charAt(6)) +
                1 * convertCharToInt(id.charAt(7)) +
                9 * convertCharToInt(id.charAt(8)) +
                7 * convertCharToInt(id.charAt(9));
    }
}
