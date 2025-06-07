import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to the Loops Demo!");
        String input = "";

        // while loop
        // scenario - process orders 1 to 5
        System.out.println("Process with a while loop:");
        int orders = 1;

        while(orders <= 5){
            System.out.println("Processing Order #" + orders);
            orders++;
        }

        // do while
        System.out.println("Process with a do while loop:");
        orders = 5;
        do{
            System.out.println("Processing order #" + orders);
            orders--;
        }while (orders > 0);

        // while evaluating user input - favorite hobbies
        System.out.println("Accept input until '!' entered:");
        System.out.println("Enter your favorite hobbies (! to quit):");
        while(!input.equals("!")){
            System.out.println("Favorite hobby?");
            input = console.nextLine();
            System.out.println(input + " entered.\n");
        }

        // for loop
        System.out.println("for loop - print 1 to 10");
        for(int i = 1; i <= 10; i++) {
            System.out.println("i = " + i);
        }

        System.out.println("for loop - print 10 to 1");
        for(int i = 10; i > 0; i--) {
            System.out.println("i =" + i);
        }

        System.out.println("Process a string in for a loop");
        String message = ("Hello! How are you?");
        for (int i = 0; i < message.length(); i++){
            System.out.println(message.charAt(i));
        }

        // break
        // while evaluating user input
        System.out.println("Accept until '!' entered");
        input = "";
        while(!input.equals("!")) {
            System.out.println("Favorite topping?");
            input = console.nextLine();
            if (input.equals("anchovies") || input.equals("!")) {
                break;
            }
            System.out.println("mmm..." + input + "\n");
        }

        // continue
        // evaluate user input for valid number (>0)
        input = "";
        System.out.println("Enter your favorite whole numbers!");
        while(!input.equals("0")) {
            System.out.println(("Favorite number?"));
            input = console.nextLine();
            int nbr = Integer.parseInt(input);
            if(nbr < 0) {
                System.out.println("Oops! Negative #s not allowed");
                continue;
            }
            System.out.println("You've entered " + nbr + ".\n");
        }

        // infinite loop
        boolean isValid = false;
        System.out.println("Even number check");
        while(!isValid){
            System.out.println("Enter an even number: ");
            input = console.nextLine();
            int nbr = Integer.parseInt(input);
            if (nbr %2 == 0) {
                System.out.println("Yep, that's an even number!");
            }else{
                System.out.println("Nope, that's an odd number.");
            }
        }


    }
}
