package pl.sda.poznan.lambda;

import org.junit.Before;
import org.junit.Test;
import pl.sda.poznan.shop.model.Product;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class LambdaExpressionTest {

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
    @Test
    public void should_map_to_names() {
        List<String> collect = this.products.stream()
                .map(p -> p.getName())
                .collect(Collectors.toList());
    }


}

//bylo w getById
/*//CWICZENIA I KOMENTARZE :
        *//* //starsze podejscie
        for (Product p : products) {
            if (p.equals(id)) {
                return p;
            }
        }
        List<Product> collect = products
                .stream()
                .filter(new ProductByIdPredicate(id))
                .collect(Collectors.toList());*//*
        *//*products
                .stream()
                .filter(product -> product.getId().equals(id));*//*
        //wyrazenie lambda
        //zapis funkcji anonimowej (bez nazwy)
        // lista_argumentow_funkcji ->
        //np.
        // public int sum(int a, int b){
        //  return a+b;
        //  }
        //    ==========
        //  (a, b)     -> a+b;

        //jezeli interfejs ma jedna metode to mozemy go zastapic wyrazeniem lambda ->interfejs funkcyjny
        //@Functional Inerface

        //default - domyslna metoda w interfejsie ktora ma cialo
        //klasy implementujace interfejs maja ta metoda ale nie musza jej ovarerridowa-implementowa ale moga

*/

//bylo w getByName
//CWICZENIA I KOMENTARZE
        /*List<Product> collect = this.products
                .stream()
                .filter(pr -> pr.getName().equals(name))
                .filter(pr -> pr.getPrice() > 500)
//        .map(product -> product.getDescription())
                .collect(Collectors.toList());
        return collect.get(0);*/

//do sortowania tez jest metoda (glupi przyklad) ale np po cenie
//collect.sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));

//dla kazdego zrob cos tam
//collect.forEach(product -> System.out.println(product.getDescription()));
// === (inny sposob to nie jest wyrazenie lambda)
//collect.forEach(System.out::println);

//po staremu by byl for iterujacy po produktach if spelni waruenk dodaj to jakiejs listy
//potem drugi for iterujacy po tej liscie i ifem sprawdzajacy czy spelni warunek
//i do nowej listy