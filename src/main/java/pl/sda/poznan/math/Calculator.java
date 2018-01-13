package pl.sda.poznan.math;

public class Calculator {
    public static int sum(String str) {
        if (str.isEmpty()) {
            return 0;
        } else if (str.length() == 1) {
            return Integer.parseInt(str);
        }
        return -1;
    }
}

//domyslnie maven na wesrsję javy 1.5
//zeby byla java 8 to w pom.xml trzeba dopisac (wpisac w neta):
/*
 <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
 */