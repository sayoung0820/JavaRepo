import java.util.List;
import java.util. Scanner;


public class TerminalUtils {
    private Scanner console;

    public TerminalUtils() {
        this.console = new Scanner(System.in);

    }

    public void displayMenu() {
        System.out.println("\n=== Media List Application ===");
        System.out.println("1. Add Media");
        System.out.println("2. Remove Media");
        System.out.println("3. Play Media");
        System.out.println("4. List All Media");
        System.out.println("5. Quit");

    }

    public int getMenuChoice() {
        int choice;
        while (true) {
            System.out.println("Choose an option: ");
            String input = console.nextLine();
            try {
                choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 5) ;
                {
                    return choice;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Invalid choice. Please enter a number between 1 and 5.");
        }
    }

    public String getString(String prompt) {
        System.out.println(prompt);
        return console.nextLine();
    }

    public int getInt(String prompt) {
        int number;
        while (true) {
            System.out.println(prompt);
            String input = console.nextLine();
            try {
                number = Integer.parseInt(input);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    public void displayMessage(String message) {
        System.out.println(message);
    }
    public void displayMediaList(List<Media> mediaList) {
        if (mediaList.isEmpty()) {
            System.out.println("No media in the library.");
            return;
        }

        System.out.println("\nCurrent Media in Library:");
        int i = 1;
        for (Media media : mediaList) {
            System.out.println(i + ". " + media.getDescription());
            i++;
        }
    }
}




