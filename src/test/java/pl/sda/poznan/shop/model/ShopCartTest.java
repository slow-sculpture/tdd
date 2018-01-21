package pl.sda.poznan.shop.model;

import org.junit.Test;
import pl.sda.poznan.shop.iterator.IteratorMy;

import static org.junit.Assert.*;

public class ShopCartTest {
    @Test
    public void shoul_iterate_through_cart(){
        ShopCart cart = new ShopCart();

        cart.add(
                CartItem.builder()
                .name("laptop")
                .unitPrice(12.00)
                .build()
        );
        cart.add(
                CartItem.builder()
                        .name("smartfon")
                        .unitPrice(122.00)
                        .build()
        );

        IteratorMy<CartItem> iterator = cart.getIterator();

        while (iterator.hasNext()){
            CartItem next = iterator.next();
            System.out.println(next);
        }
    }

}