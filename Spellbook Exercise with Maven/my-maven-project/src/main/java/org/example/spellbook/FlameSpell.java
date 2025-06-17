package org.example.spellbook;

public class FlameSpell implements Spell {

    @Override
    public void cast() {
        System.out.println("You launch a blaze a searing hot flames of fire!");
    }

    @Override
    public String getIncantation() {
        return "flames";
    }
}
