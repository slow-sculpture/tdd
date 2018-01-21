package pl.sda.poznan.shop.file.product;

import pl.sda.poznan.shop.model.Product;

import java.io.IOException;
import java.util.List;

public class XmlProductFileWriter implements ProductFileWriter {
    private String path;

    public XmlProductFileWriter(String path) {
        this.path = path;
    }


    @Override
    public void saveToFile(List<Product> elements) throws IOException {
        throw new UnsupportedOperationException();
    }
}
