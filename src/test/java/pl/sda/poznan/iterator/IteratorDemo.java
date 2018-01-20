package pl.sda.poznan.iterator;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class IteratorDemo {
    @Test
    public void test(){
        List<String> stringList = Arrays.asList("Piotr", "Test", "Imie");

        for(int i=0;i<stringList.size(); i++){
            System.out.println(stringList.get(i));
        }

        for(String s:stringList){
            System.out.println(s);
        }
        //=====
        // tak to dziala

        while (stringList.iterator().hasNext()){
            String element = stringList.iterator().next();
            System.out.println(element);
        }
    }
}
