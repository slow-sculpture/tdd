package pl.sda.poznan.shop.repository;

import org.junit.Before;
import org.junit.Test;
import pl.sda.poznan.shop.model.Product;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ProductRepositoryTest {

    //tylko do testowania wyrazen lambda - do nauki nie do fumcjnolanosci programu
    private List<Product> products;

    @Before
    public void init() {
        Product smatphone = new Product("Nokia", "Desc", 500D);
        Product laptop = new Product("Dell", "ultrabook", 1500D);
        Product console = new Product("Xbox", "One", 2000.00);

        this.products = Arrays.asList(smatphone, laptop, console);
    }


    @Test
    public void test() {


        //lambda
        List<Product> results = products
                .stream()
                .filter(myProduct -> myProduct.getPrice() > 1000)
                .collect(Collectors.toList());


        assertEquals(2, results.size());
        assertEquals(3, products.size());
    }

    @Test
    public void should_find_where_starts_with_given_letter() {
        //produkty drozsze niz 1000 i zaczynajace sie od x
        List<Product> results = products

                .stream()
                .filter(p -> p.getPrice() > 1000)
                .filter(p -> p.getName().startsWith("X"))
                .collect(Collectors.toList());
        assertEquals(1, results.size());
    }

    @Test
    public void should_costam() {
        List<Product> result = products
                .stream()
                //filtr tanszy niz 2000
                .filter(product -> product.getPrice() < 2000)
                .collect(Collectors.toList());

        ////
        if (result.size() > 0) {
            Product first = result.get(0);
            if (first == null) {
                //throw new NoSuchFieldException();
            }
        }
        ////

        // ===================

        ////
        Optional<Product> first = result.stream().filter(product -> product.getPrice() > 100).findFirst();
        //powyzsze sluzy to wskazania ze produkt moze tam byc ale moze byc null i nie wywali exception
        Product p = first.orElseThrow(() -> new NoSuchElementException());
        // ===
        Product p2 = first.orElseThrow(NoSuchElementException::new);
        ////

    }

    //posortuj po nazwie alfabetycznie
    @Test
    public void should_sort_by_name() {
        this.products.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        //   ====
        // method reference:
        this.products.sort(Comparator.comparing(Product::getName));
    }

    //dla kazdego produktu pobierz jego nazwe na liscie
    // result.forEach(product -> System.out.println(product.getName());


}

