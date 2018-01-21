package pl.sda.poznan.shop.chor;

public class PinPayment extends BasePayment{
    public PinPayment(Account account) {
        super(account);
    }

    @Override
    protected boolean canHandle(Double amount) {
        return amount<1000;
    }

    @Override
    protected boolean pay(Double amount) {
        System.out.println("Platnosc z pinem");
        System.out.println("Pobieranie pinu i weryfikacja.....");
        return account.withdraw(amount);
    }
}
