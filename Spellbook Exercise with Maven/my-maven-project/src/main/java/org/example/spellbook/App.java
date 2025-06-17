package org.example.spellbook;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        SpellBook spellbook = new SpellBook();

        System.out.println("\nWelcome to the Spellbook!");

//        boolean running = true;
//        String choice = "";

        while (true) {
            System.out.println("\nEnter your spell incantation to case it!");
            System.out.println("1. Enter 'creature' for Random Creature Spell");
            System.out.println("2. Enter 'heal' for Healing Spell");
            System.out.println("3. Enter 'ascend' for Levitation Spell");
            System.out.println("4. Enter 'flames' for Flame Spell");
            System.out.println("5. Enter 'quit' to exit");

            System.out.println();

            String choice = console.nextLine().trim().toLowerCase();
            spellbook.runIncantation(choice);
        }
    }
}

