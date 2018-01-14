package pl.sda.poznan.shop.lambda;

public class Program {
    public static void main(String[] args) {
        Calculator calc = new BaseCalculator();
        int sum = calc.calculate(2, 2);
        System.out.println(sum);

        ///////////////////

        //with lambda
        Calculator calcLambda = (a, b) -> a + b;
        int sum2 = calcLambda.calculate(4, 4);
        System.out.println(sum2);

        ///////////////////
        calculateExpressionWithLambda((a, b) -> {
            return a + b;
        });

        ///  ======

        int summary = calculateExpressionWithLambda((a, b) -> a + b);

        int substraction = calculateExpressionWithLambda((a, b) -> a - b);

        int multiplication = calculateExpressionWithLambda((a, b) -> a * b);

        int division = calculateExpressionWithLambda((a, b) -> a / b);

    }

    public static int calculateExpressionWithLambda(Calculator calculator) {
        int a = 5;
        int b = 10;
        return calculator.calculate(a, b);
    }
}
