package pl.sda.poznan.shop.file.product;

import pl.sda.poznan.shop.model.Product;

import java.io.IOException;
import java.util.List;

public class JsonProductFileWriter implements ProductFileWriter {
    private String path;

    public JsonProductFileWriter(String path) {
        this.path = path;
    }


    @Override
    public void saveToFile(List<Product> elements) throws IOException {
        throw new UnsupportedOperationException();
    }
}
