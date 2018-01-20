package pl.sda.poznan.shop.repository;

import pl.sda.poznan.shop.model.Product;
import pl.sda.poznan.shop.model.ProductByIdPredicate;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ProductRepository {

    private static Long id = 1L;
    private List<Product> products;

    public Product add(Product product) {
        //nadac id dla produktu
        product.setId(id++);
        this.products.add(product);
        return product;
    }

    public Product getById(Long id) {
        //starsze podejscie
        for (Product p : products) {
            if (p.equals(id)) {
                return p;
            }
        }
        List<Product> collect = products
                .stream()
                .filter(new ProductByIdPredicate(id))
                .collect(Collectors.toList());
        /*products
                .stream()
                .filter(product -> product.getId().equals(id));*/
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

        throw new UnsupportedOperationException();
    }

    public Product getByName(String name) {
        List<Product> collect = this.products
                .stream()
                .filter(pr -> pr.getName().equals(name))
                .filter(pr -> pr.getPrice() > 500)
//        .map(product -> product.getDescription())
                .collect(Collectors.toList());
        return collect.get(0);

        //do sortowania tez jest metoda (glupi przyklad) ale np po cenie
        //collect.sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));

        //dla kazdego zrob cos tam
        //collect.forEach(product -> System.out.println(product.getDescription()));
        // === (inny sposob to nie jest wyrazenie lambda)
        //collect.forEach(System.out::println);

        //po staremu by byl for iterujacy po produktach if spelni waruenk dodaj to jakiejs listy
        //potem drugi for iterujacy po tej liscie i ifem sprawdzajacy czy spelni warunek
        //i do nowej listy

    }

    public void remove(Long id) {
        throw new UnsupportedOperationException();
    }

    public void remove(Product product) {
        throw new UnsupportedOperationException();
    }

    public int count() {
        throw new UnsupportedOperationException();
    }
}
