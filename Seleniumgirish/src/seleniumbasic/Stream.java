package seleniumbasic;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class Stream {

    @Test
    public void regular() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Amit");
        names.add("Arjun");
        names.add("Akshay");
        names.add("Girish");
        names.add("Alekhya");

        int count = 0;

        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);
            if (actual.startsWith("A")) {
                count++;
            }
        }

        System.out.println("Count of names starting with 'A': " + count);
    }
}
