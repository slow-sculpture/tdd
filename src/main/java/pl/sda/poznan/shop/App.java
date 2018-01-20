package pl.sda.poznan.shop;

import pl.sda.poznan.shop.model.CartItem;
import pl.sda.poznan.shop.model.Product;
import pl.sda.poznan.shop.model.ShopCart;
import pl.sda.poznan.shop.repository.ProductRepository;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        initializeApp();
        boolean exit = false;
        ShopCart cart = new ShopCart();
        while (!exit) {

            printMenu();

            Scanner scanner = new Scanner(System.in);
            int wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    System.out.println("\nLista produktow: ");
                    ProductRepository.getInstance()
                            .getAll()
                            .forEach(System.out::println);
                    //==.forEach(p-> System.out.println(p.toString()));

                    break;
                case 2:
                    System.out.println("Podaj id produktu:");
                    long productId = scanner.nextInt();
                    Product product = ProductRepository.getInstance().getById(productId);
                    System.out.println("Wybrales: " + product.toString());
                    System.out.println("Podaj ilosc: ");
                    int quantity = scanner.nextInt();

                    //logika dodawania do koszyka
                    //I sposob -- all args constructor
                    //CartItem cartItem = new CartItem(product.getName(), product.getDescription(), product.getPrice(), quantity);

                    //II sposob -- Java Beans method
                    CartItem cartItem1 = new CartItem();
                    cartItem1.setName(product.getName());
                    cartItem1.setDescription(product.getDescription());
                    cartItem1.setUnitPrice(product.getPrice());
                    cartItem1.setQuantity(quantity);

                    //III sposob -- wzorzec Builder
                    CartItem build = CartItem.builder()
                            .description(product.getDescription())
                            .name(product.getName())
                            .build();

                    cart.add(build);
                    System.out.println("Dodano element do koszyka");
                    break;
                case 9:
                    System.out.println("Logowanie...");
                    System.out.println("Podaj login: ");
                    System.out.println("Podaj haslo: ");
                    break;
                case 10:
                    System.out.println("Rejestracj... \nWypelnij dane: ");
                    System.out.println("Imie: ");
                    System.out.println("Nazwisko: ");
                    System.out.println("Email: ");
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Wychodze z programu");
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println(" ");
        System.out.println("Menu: ");
        System.out.println("1. Wyswietl wszystkie produkty");
        System.out.println("2. Dodawanie do koszyka");


        System.out.println("9. Logowanie");
        System.out.println("10. Rejestracja");
        System.out.println("0. Wysjcie");
    }

    //wraper
    private static void initializeApp(){
        seedProducts();
    }

    //wypelniamy jakimis testowymi danymi
    private static void seedProducts() {
        Product smartphone = new Product("Nokia", "Desc", 500D);
        Product laptop = new Product("Dell", "ultrabook", 1500D);
        Product console = new Product("Xbox", "One", 2000.00);

        ProductRepository
                .getInstance()
                .add(Arrays.asList(smartphone, laptop, console));
    }
}
