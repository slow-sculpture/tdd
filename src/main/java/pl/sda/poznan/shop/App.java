package pl.sda.poznan.shop;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {

            printMenu();

            Scanner scanner = new Scanner(System.in);
            int wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    System.out.println("\nLista produktow: ");
                    break;
                case 2:
                    System.out.println("Logowanie...");
                    System.out.println("Podaj login: ");
                    System.out.println("Podaj haslo: ");
                    break;
                case 3:
                    System.out.println("Rejestracj... \nWypelnij dane: ");
                    System.out.println("Imie: ");
                    System.out.println("Nazwisko: ");
                    System.out.println("Email: ");
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Wychodze z programu");
                    exit=true;
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
        System.out.println("2. Logowanie");
        System.out.println("3. Rejestracja");
        System.out.println("0. Wysjcie");
    }
}
