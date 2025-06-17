package org.example.spellbook;

public class HealingSpell implements Spell {

    @Override
    public void cast() {
        System.out.println("A warm light surrounds you and your wounds begin to heal!");
    }

    @Override
    public String getIncantation() {
        return "heal";
    }
}
