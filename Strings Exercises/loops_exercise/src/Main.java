import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = "";


        // Count to 100 with for loop
        for (int i = 1; i <= 100; i++) {
            System.out.println("i = " + i);
        }

        // Modified to print only even numbers
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println("i = " + i);
            }
        }

        // Countdown timer with while loop
        System.out.println("Please enter a starting number!");
        input = console.nextLine();
        int nbr = Integer.parseInt(input);

        while (nbr > 0) {
            System.out.println(nbr);
            nbr--;
        }
        System.out.println("Blast off!");

        // Gues number with do while
//        Random random = new Random();
//        int secretNumber = random.nextInt(50) + 1;
//        int userGuess;
//        System.out.println("Guess a number between 1 and 50!");
//        do {
//            System.out.println("Enter your guess: !");
//            userGuess = console.nextInt();
//            if (userGuess != secretNumber) {
//                System.out.println("Wrong number! Try again.\n");
//            }
//        } while (userGuess != secretNumber);
//        System.out.println("You got it! Great guessing! The number was " + secretNumber + "!");

        // Multiplication Table (For loop)
        int userNumber;
        System.out.println("Enter a number to see the multiplication table!");
        userNumber = console.nextInt();
        for (int i = 1; i <= 10; i++) {
            int result = i * userNumber;
            System.out.println(userNumber + "x" + i + "=" + result);
        }


        // Password validator (while loop)
        String passwordGuess = "";
        System.out.println("Enter the correct password.");
        passwordGuess = console.nextLine();
        while (!passwordGuess.equals("letmein")) {
            System.out.println("Incorrect password. Try again");
            passwordGuess = console.nextLine();
        }
        System.out.println("Access granted!");

        // Find first vowel
        System.out.println("Enter any word:");
        input = console.nextLine();
        boolean foundVowel = false;
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            switch (letter) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("The first vowel is at index: " + i);
                    foundVowel = true;
                    break;
            }
            if (foundVowel) {
                break;
            }
        }
        if (!foundVowel) {
            System.out.println("No vowels found in that word.");
        }


        // ATM System do while loop
        double acctBalance = 500.00;
        System.out.println("Welcome to the ATM machine!");
        do {
            System.out.println("Enter 1. Withdraw, 2. Deposit, 3. Check Balance, or 4. Exit");
            System.out.println("enter a number choice 1 - 4");
            input = console.nextLine();

            if (input.equals("1")) {
                System.out.println("Enter amount to withdraw");
                double amount = Double.parseDouble((console.nextLine()));
                if (amount > acctBalance) {
                    System.out.println("Insufficient funds!");
                } else {
                    acctBalance -= amount;
                    System.out.println("Withdrawal successful. New balance: $" + acctBalance);
                }
            } else if (input.equals("2")) {
                System.out.println("Enter amount to deposit: ");
                double amount = Double.parseDouble((console.nextLine()));
                acctBalance += amount;
                System.out.println("Deposit successful. Current balance is: $" + acctBalance);
            } else if (input.equals("3")) {
                System.out.println("Current Balance is: $" + acctBalance);
            } else if (input.equals("4")) {
                break;
            }
        } while (!input.equals("4"));
        System.out.print("Thanks for using the ATM! Bye!");


        // FizzBuzz (for loop)
        for (int i = 1; i <= 100; i++) {
            System.out.println("i = " + i);
            if(i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if(i % 3 == 0){
                System.out.print("Fizz");
            }else if(i % 5 == 0){
                System.out.println("Buzz");
            }
        }

        // Reverse string (for loop)
        System.out.println("Please enter a word!");
        String word = console.nextLine();
        for(int i = word.length() - 1; i >=0; i--) {
            System.out.println("Reversed word: " + word.charAt(i));
        }

        // Prime Number Checker (While Loop)
        boolean isPrime = true;
        int i = 2;
        System.out.print("Please enter a number");
        input = console.nextLine()
        int number = Integer.parseInt(input);







    }
}








