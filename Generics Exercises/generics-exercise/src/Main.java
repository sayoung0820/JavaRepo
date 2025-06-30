import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<Box<Integer>> boxes = new ArrayList<>();

        Box<Integer> box1 = new Box<>();
        box1.set(252);
        Box<Integer> box2 = new Box<>();
        box2.set(175);
        Box<Integer> box3 = new Box<>();
        box3.set(369);

        boxes.add(box1);
        boxes.add(box2);
        boxes.add(box3);

        System.out.println("\nList or items by item number: ");
        for (Box<Integer> box : boxes) {
            System.out.println(box.get());
        }


        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println("Integer in box: " + intBox.get());

        Box<String> stringBox = new Box<>();
        stringBox.set("Hello this is a test!");
        System.out.println("String in box: " + stringBox.get());



        }
    }
