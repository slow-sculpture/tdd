package pl.sda.poznan.shop.file.product;

import pl.sda.poznan.shop.model.Product;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class TxtProductFileWriter implements ProductFileWriter {
    private String path;

    public TxtProductFileWriter(String path) {
        this.path = path;
    }

    @Override
    public void saveToFile(List<Product> elements) throws IOException {
        //mapowanie elements na znaki (CharSequence -> ktora w Paths.get... nizej jest obslugiawana po wduszeniu ctrl+p pisza)
        List<String> collect = elements.stream()
                .map(product -> product.toString()) //z wykorzystanie method referencje .map(String::toString)
                .collect(Collectors.toList());

        Files.write(Paths.get(path), collect);

    }
}
