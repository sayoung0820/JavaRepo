package org.example.spellbook;
import java.util.ArrayList;


public class SpellBook {
    private ArrayList<Spell> spells;

    public SpellBook() {
        spells = new ArrayList<>();
        spells.add(new HealingSpell());
        spells.add(new LevitateSpell());
        spells.add(new FlameSpell());
        spells.add(new RandomCreaturelSpell());
        spells.add(new ExitSpell());
    }

    public void runIncantation(String incantation) {
        for (Spell spell : spells) {
            if (spell.getIncantation().equalsIgnoreCase(incantation)) {
                spell.cast();
                return;
            }
        }
        System.out.println("Your powers weren't strong enough to invoke the spell! Try again!");
    }
}

