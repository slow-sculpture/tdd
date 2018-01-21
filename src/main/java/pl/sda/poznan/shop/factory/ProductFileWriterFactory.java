package pl.sda.poznan.shop.factory;

import pl.sda.poznan.shop.file.product.JsonProductFileWriter;
import pl.sda.poznan.shop.file.product.ProductFileWriter;
import pl.sda.poznan.shop.file.product.TxtProductFileWriter;
import pl.sda.poznan.shop.file.product.XmlProductFileWriter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProductFileWriterFactory implements Factory<String, ProductFileWriter> {

    Map<String, ProductFileWriter> writerMap = new HashMap<>();

    //kluczem jest funkcja ktora sprawdza czy plik konczy sie na np. ".txt"
    //a wartoscia jest funkcja ktora jako argument przyjmuje sciezke i zwraca nowy obiekt typu konkretnego czytnika
    Map<Predicate<String>, Function<String, ProductFileWriter>> map = new HashMap<>();

    public ProductFileWriterFactory() {
        //inicjalizujemy mape
//        writerMap.put(".txt", new TxtProductFileWriter("?"));
//        writerMap.put(".xml", new XmlProductFileWriter("?"));
//        writerMap.put(".json", new JsonProductFileWriter("?"));

        map.put(s->s.endsWith(".txt"), s-> new TxtProductFileWriter(s));
        map.put(s->s.endsWith(".xml"), s-> new XmlProductFileWriter(s));
        map.put(s->s.endsWith(".json"), JsonProductFileWriter::new);
    }

    @Override
    public ProductFileWriter create(String path) {

        //musimy przeiterowac przez caly slownik i dla kazdej wartosci wywolujemy funckje predykatu
        //jezeli zwroci true to uruchamiamy funkcje odpowiedzialna za tworzenie obiektu
        //tej logiki nie potrzebujemy zmieniac jesli pojawi sie nowy czytnik to uzupelniamy tylko mape
        for(Map.Entry<Predicate<String>, Function<String, ProductFileWriter>> e : map.entrySet()){
            if(e.getKey().test(path)){  // metoda test -> z interfejsu funkcyjnego Predicate
                return e.getValue().apply(path);  //metoda apply -> metoda z interfejsu funkcyjnego Function
            }
        }
        return null;

    }
}
