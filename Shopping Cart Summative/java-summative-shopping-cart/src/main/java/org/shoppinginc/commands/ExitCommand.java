package org.shoppinginc.commands;

public class ExitCommand implements CommandManager {

    @Override
    public boolean execute() {
        System.out.println("Thanks for using the Shopping Cart App. Goodbye!");
        return false;
    }

}
