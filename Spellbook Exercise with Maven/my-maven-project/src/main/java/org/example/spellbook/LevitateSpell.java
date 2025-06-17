package org.example.spellbook;

public class LevitateSpell implements Spell {

    @Override
    public void cast() {
        System.out.println("You suddenly ascend into the air and begin levitating!");
    }

    @Override
    public String getIncantation() {
        return "ascend";
    }
}
