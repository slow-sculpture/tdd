package pl.sda.poznan.shop.model;

public class CartItem {

    private String name;
    private String description;
    private double unitPrice;
    private int quantity;

    public CartItem() {
    }

    public CartItem(String name, String description, double unitPrice, int quantity) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    /////////////////
    //wzorzec Builder
    //klsa w klasie

    //5. metoda statyczna fabrykujaca tworzaca builder
    public static CarItemBuilder builder() {
        return new CarItemBuilder();
    }
    //1. stworzenie klasy wewnetrznej public static class CartItemBuilder
    public static class CarItemBuilder {
        //2. utworzyc te same pola co glowna klasa
        private String name;
        private String description;
        private double unitPrice;
        private int quantity;

        //3.
        public CarItemBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CarItemBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CarItemBuilder unitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public CarItemBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        //4. metoda budujaca zwracajaca finalny obiekt
        public CartItem build() {
            return new CartItem(this.name, this.description, this.unitPrice, this.quantity);
        }
    }


}
