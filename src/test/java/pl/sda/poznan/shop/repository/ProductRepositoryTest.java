package pl.sda.poznan.shop.repository;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductRepositoryTest {
    @Test
    public void should_retunr_same_instance(){
        ProductRepository firstInstance = ProductRepository.getInstance();
        ProductRepository secondInstance = ProductRepository.getInstance();

        boolean isSameInstance = firstInstance == secondInstance;
        assertEquals(true, isSameInstance);

        // ===
        assertSame(firstInstance,secondInstance);

        //to jest ta sama instancja przez wzorzec Singleton -> mozliwe utworzenie tylko jednego obiektu
    }

}