package pl.sda.poznan.shop.factory;

import org.junit.Test;
import pl.sda.poznan.shop.file.product.ProductFileWriter;
import pl.sda.poznan.shop.file.product.TxtProductFileWriter;

import static org.junit.Assert.*;

public class ProductFileWriterFactoryTest {

    @Test
    public void create(){
        ProductFileWriterFactory productFileWriterFactory = new ProductFileWriterFactory();
        ProductFileWriter productFileWriter = productFileWriterFactory.create("plik.txt");

        assertEquals(TxtProductFileWriter.class, productFileWriter.getClass());
    }

}