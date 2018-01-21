package pl.sda.poznan.shop.chor;

public abstract class BasePayment implements Payment {
    //jak nie obsluzy to przekaze dalej
    protected Payment nextPayment;

    protected Account account;

    public BasePayment(Account account) {
        this.account = account;
    }

    @Override
    public boolean handle(Double amount) {
        //spr czy moge to obsluzyc
        if(canHandle(amount)){
            return pay(amount);
        } else if (nextPayment!=null){
            return nextPayment.handle(amount);
        }
        return false;
    }

    @Override
    public void setNextHandler(Payment nextHandler) {
        this.nextPayment=nextHandler;
    }

    //metoda spr czy dana klasa ma taka odpowiedzialnosc
    protected abstract boolean canHandle(Double amount);
    //metoda obslugujaca platnosci
    protected abstract boolean pay(Double amount);
}
