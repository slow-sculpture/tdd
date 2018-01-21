package pl.sda.poznan.shop.chor;

public class PaypassPayment extends BasePayment{

    public PaypassPayment(Account account) {
        super(account);
    }

    @Override
    protected boolean canHandle(Double amount) {
        return amount <50;
    }

    @Override
    protected boolean pay(Double amount) {
        System.out.println("Platnosc zblizeniowa");
      return account.withdraw(amount);
    }
}
