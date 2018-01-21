package pl.sda.poznan.shop.file;

import java.io.IOException;
import java.util.List;

public interface FileWriter<E> {
    void saveToFile (List<E> elements) throws IOException;
}
