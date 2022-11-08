package arrayList;

import java.util.*;

public class ArrayListTest {
    public static void main(String... args) {
        // fill the staff array list with three Employee objects
        ArrayList<String> staff = new ArrayList<>();

        staff.add("u");
        staff.add("v");
        staff.add("w");

        // print out information about all Employee objects
        for (String s : staff) {
            System.out.println(s);
        }
    }
}
