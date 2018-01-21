package pl.sda.poznan.shop.chor;

import org.junit.Test;

import static org.junit.Assert.*;

public class BasePaymentTest {
    @Test
    public void pay(){
        Account account = new Account();
        account.setBalance(1000D);
        Payment paypass = new PaypassPayment(account);
        Payment pinpay = new PinPayment(account);

        paypass.setNextHandler(pinpay);
        paypass.handle(1000D);
    }

}