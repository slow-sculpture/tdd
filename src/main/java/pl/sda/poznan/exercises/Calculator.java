package pl.sda.poznan.exercises;

public class Calculator {
    public static int sum(String str) {
        if (str.isEmpty()) {
            return 0;
        } else if (str.length() == 1) {
            return parseInteger(str);
        } else {
            return sumNumbers(str);
        }
    }

    private static int sumNumbers(String str) {
        String[] split = str.split(",");
        int result = 0;
        for(int i = 0; i < split.length; i++){
            result += parseInteger(split[i]);
        }
        return result;
    }

    private static int parseInteger(String s){
        return Integer.parseInt(s);
    }
}

//domyslnie maven ma wesrsję javy 1.5
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