package pl.sda.poznan.shop.lambda;

public class BaseCalculator implements Calculator {
    @Override
    public int calculate(int a, int b) {
        return a+b;
    }
}
