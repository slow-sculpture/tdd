package pl.sda.poznan.shop.model;

import pl.sda.poznan.shop.iterator.IterableMy;
import pl.sda.poznan.shop.iterator.IteratorMy;

import java.util.ArrayList;

import java.util.List;

public class ShopCart implements IterableMy<CartItem> {
    private List<CartItem> cartItem = new ArrayList<>();
    private double sum;

    public void add(CartItem cartItem) {
        this.cartItem.add(cartItem);
        this.sum += cartItem.getUnitPrice() * cartItem.getQuantity();
    }

    public double getSum() {
        return sum;
    }


    @Override
    public IteratorMy<CartItem> getIterator() {
        return new IteratorMy<CartItem>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < cartItem.size();
            }

            @Override
            public CartItem next() {
                return cartItem.get(index++);
            }

            @Override
            public void reset() {
                index = 0;
            }
        };
    }
}
