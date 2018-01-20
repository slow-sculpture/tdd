package pl.sda.poznan.shop.repository;

import pl.sda.poznan.shop.exceptions.ProductNotFoundException;
import pl.sda.poznan.shop.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ProductRepository {

    //chcemy zabronic utworzenia wiecej niz jednego obiektu klasy
    //wzorzec Singleton

    //krok 2.
    private static ProductRepository instance = new ProductRepository();

    //krok 1. prywatny konstruktor
    private ProductRepository() {
    }

    //krok 3.
    public static ProductRepository getInstance() {
        return instance;
    }


    private static Long id = 1L;
    private List<Product> products = new ArrayList<>();


    public Product add(Product product) {
        //nadac id dla produktu
        product.setId(id++);
        this.products.add(product);
        return product;
    }

    public void add(List<Product> products) {
        //1. method reference
        //czyt. dla kazdej ta metode
        products.forEach(this::add);
        /*
        2. lambda expression
        products.forEach(product -> this.add(product));

        3. for loop
        for(Product product:products){
            this.add(product);
            */
    }


    public List<Product> getAll() {
        return this.products;
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

    public boolean remove(Long id) {
        return this.products.removeIf(p -> p.getId().equals(id));
    }

    public boolean remove(Product product) {
        return this.products.remove(product);
    }

    public int count() {
        return this.products.size();
    }
}
