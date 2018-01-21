package pl.sda.poznan.shop.chor;

public interface Payment {
    boolean handle(Double amount);
    void setNextHandler(Payment nextHandler);
}
