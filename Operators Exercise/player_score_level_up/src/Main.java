public class Main {
    public static void main(String[] args) {
        // declare and assign variables
        int currentXP = 1200;
        int level = 5;
        int xpToNextLevel = 1500;
        boolean levelUp;

        // Add 300 xp when player completes a quest
        int questBoost = 300;
        currentXP += questBoost;

        // Reduce xpToNextLevel, amount needed to level up
        xpToNextLevel -= 300;

        // Multiply XP boost by 2 if player earns double boost
        int doubleBoost = 300 * 2;
        currentXP += doubleBoost;

        // Reduce amount needed to level up if double boost
        xpToNextLevel -= doubleBoost;

        // Check if currentXp is greater than or equal to xpNextLevel
        boolean hasEnoughXP = currentXP >= xpToNextLevel;
        boolean reachedMax = level >= 10;

        // Determine if player levels up (XP requirement met AND reached level = 10)
        levelUp = hasEnoughXP && !reachedMax;

        // Determine if player is a pro (level > 7 or XP over 5000)
       boolean isPro = (level > 7) || (currentXP > 5000);

       System.out.println("Current XP: " + currentXP);
       System.out.println("XP needed for next level: " + xpToNextLevel);
       System.out.println("Current level: " + level);
       System.out.println("Level Up?: " + levelUp);
       System.out.println("Is Pro Player?: " + isPro);








    }
}
