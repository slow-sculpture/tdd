package pl.sda.poznan.shop.chor;

public class Account {
    private Double balance;
    private int pin;
    private String ownerName;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }


    //wyplata z konta
    public boolean withdraw(Double amount){
        if(this.balance>amount){
            this.balance-=amount;
            return true;
        }
        return false;
    }
}
