import java.util.Scanner;

public class code_along {
    public static void main(String[] arg) {
        Scanner console = new Scanner(System.in);

        System.out.println("*** Welcome to the Theater ");
        System.out.println("Please enter the ticket info below.\n");

        // Prompt for movie title
        System.out.println("What movie would you like to see? ");
        String movie = console.nextLine();

        // Prompt user for movie time (1pm, 2:30pm, etc)
        System.out.println("There are 3 matinees available: 1pm, 2:30pm, 4pm\nWhat time?");
        String movieTime = console.nextLine();

        // Prompt user for # of adult tickets
        System.out.println("# of Adult Tickets: ");
        String adultTisString = console.nextLine();
        int adultTix = Integer.parseInt(adultTisString);



    }
}
