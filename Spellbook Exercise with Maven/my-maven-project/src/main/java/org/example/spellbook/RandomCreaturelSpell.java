package org.example.spellbook;

import java.util.Random;

public class RandomCreaturelSpell implements Spell {

    private String[] creatures = {
            "unicorn", "centaur", "troll", "goblin", "wolf", "dragon"};

    @Override
    public void cast() {
        Random rand = new Random();
        int i = rand.nextInt(creatures.length);
        String chosen = creatures[i];
        System.out.println("You suddenly turn into a " + chosen + " !");
    }

    @Override
    public String getIncantation() {
        return "creature";


    }
}
