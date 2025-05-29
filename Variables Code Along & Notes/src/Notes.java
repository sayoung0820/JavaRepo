public class Notes {

    public static void main(String[] args) {

        /* When we use a variable in Java, we must declare and assign it first
        To do this we use a "declaration statement". The declaration statement
        must have the variable name and type followed by a semicolon > type variable ;
        ex: int appleCount = 24;
        We can also declare multiple variable of the same type in one line then add the value after
        ex: int appleCount, bananaCount, orangeCount;
         */
        int appleCount, bananaCount, orangeCount;
        appleCount = 23;
        bananaCount = 67;
        orangeCount = 354;

        // Once assigned, we can print the variables using code System.out.println()
        System.out.println(appleCount);

        // We can change the value of variable by assigning it again
        appleCount = 45;
        System.out.println(appleCount);

        int cherryCount = 10;
        int grapeCount = 10;
        int fruitTotal = cherryCount + grapeCount;
        System.out.println(fruitTotal);

        char answer = 'X';
        char alpha = 80, bravo = 98, charlie = 99;
        System.out.println(alpha);
        System.out.println(bravo);
        System.out.println(charlie);

    }
//}

package org.example;

public class Notes {

    public static void main(String[] args) {

 System.out.println(1 + 1);


        int myAge = 46;
        System.out.println(myAge);

        boolean aliceIsThirsty = true;
        boolean bobIsThirsty = false;
        System.out.println(aliceIsThirsty);
        System.out.println(bobIsThirsty);

        char alpha = 'a';
        char thisIsALowerCaseB = 98;
        System.out.println(alpha);
        System.out.println(thisIsALowerCaseB);

        float taxRate = .07f;
        float subtotal = 20.05f;
        float tax = subtotal * taxRate;
        float total = subtotal + tax;
        System.out.println("$" + subtotal);
        System.out.println("$" + tax);
        System.out.println("--------------");
        System.out.println("$" + total);
    }
}

