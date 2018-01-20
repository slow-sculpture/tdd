package pl.sda.poznan.shop.repository;

import pl.sda.poznan.shop.exceptions.ProductNotFoundException;
import pl.sda.poznan.shop.model.Product;
import pl.sda.poznan.shop.model.ProductByIdPredicate;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
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
        Optional<Product> first = this.products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
        return first
                .orElseThrow(() ->
                                new
                                        ProductNotFoundException("Nie ma produktu o takim id")
                        //rozszerza RuntimeException ->wyjatek niekontrolowany nie trzeba go obslugiwac
                        //ani dodawac przy nazwie metody
                );


    }

    public Product getByName(String name) {
        Optional<Product> first = this.products.stream().filter(x -> x.getName().equals(name))
                .findFirst();
        return first
                .orElseThrow(() ->
                        new ProductNotFoundException
                                ("Nie mozna znalezc produktu o danej nazwie"));


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
