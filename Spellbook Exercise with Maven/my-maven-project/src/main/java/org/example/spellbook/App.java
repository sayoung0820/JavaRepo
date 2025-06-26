package org.example.spellbook;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        SpellBook spellbook = new SpellBook();

        System.out.println("\nWelcome to the Spellbook!");


        while (true) {
            System.out.println("\nEnter your spell incantation to case it!");
            System.out.println("1. Enter 'creature' to be turned into a random forest creature");
            System.out.println("2. Enter 'heal' to be magically healed");
            System.out.println("3. Enter 'ascend' to magically levitate");
            System.out.println("4. Enter 'flames' to magically shoot a ball of flames");
            System.out.println("5. Enter 'quit' to exit");

            System.out.println();

            String choice = console.nextLine().trim().toLowerCase();
            spellbook.runIncantation(choice);
        }
    }
}

