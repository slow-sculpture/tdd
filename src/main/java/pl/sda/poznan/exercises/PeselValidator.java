package pl.sda.poznan.exercises;

public class PeselValidator {
    private int[] parameters = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7};

    public boolean validate(String id) {
        if(id.isEmpty() || id.length() !=11){
            throw new IllegalArgumentException("Length error");
        }
        int result = calculateControlSumUsingParameteres(id);
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
    private int calculateControlSumUsingParameteres(String id){
        int controlSum = 0;
        for(int i=0;i<id.length()-1; i++){
            controlSum+=parameters[i]*convertCharToInt(id.charAt(i));
        }
        return controlSum;
    }
}
