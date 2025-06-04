import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Are you tax exempt? (y/n) ");
        String exempt = console.nextLine();

        System.out.println("Will you require shipping? (y/n) ");
        String shipping = console.nextLine();

        System.out.println("Please enter your order quantity: ");
        String quantityStr = console.nextLine();
        int quantity = Integer.parseInt(quantityStr);

        System.out.println("Please enter the promo code for free shipping or type NONE: ");
        String code = console.nextLine();

        System.out.println("                                         ");

        System.out.println("Details: ");

        System.out.println("Tax Exempt: " + exempt);
        System.out.println("Shipping required: " + shipping);
        System.out.println("Quantity of products: " + quantity);
        System.out.println("Promo Code: " + code);

        System.out.println("                                         ");

        System.out.println("Bye!");






    }
}
