import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("James");
        names.add("Shannon");
        names.add("Gia");

        java.util.Collections.sort(names);
        System.out.println(names);

//        String allNames = names.get(0);
//
//        System.out.println(allNames);
//
//        names.remove(0);
//        System.out.println(names);

//        System.out.println(names.size());

        System.out.println(names.isEmpty());






        }
    }