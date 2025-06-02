public class Main {

    enum OrderStatus {
        PENDING,
        PROCESSING,
        SHIPPED,
        DELIVERED
    }

    enum ShippingStatus {
        STANDARD,
        TWO_DAY,
        OVERNIGHT
    }

    public static void main(String[] args) {
        OrderStatus orderStatus = OrderStatus.PROCESSING;
        ShippingStatus shippingStatus = ShippingStatus.TWO_DAY;

        System.out.println(ShippingStatus.STANDARD);
        System.out.println(ShippingStatus.TWO_DAY);
        System.out.println(ShippingStatus.OVERNIGHT);
        System.out.println("Oder Status" + orderStatus);

        System.out.println(OrderStatus.PENDING);
        System.out.println(OrderStatus.PROCESSING);
        System.out.println("Ship Status: " + shippingStatus);


        // Assign variables
        int productID = 1;
        int productCategory = 2;
        double productCost = 2.56;
        double productPrice = 4.99;
        int productQuantity = 78;

        // Write code to calculate total cost of the product based on the inventory
        // Print the value
        double totalCost = productCost * productQuantity;
        System.out.println("The total cost of the product is: " + totalCost);

        // Calculate profit of the product. Print value.
        double profitMargin = productPrice - productCost;
        System.out.println("The Profit in dollars is: " + profitMargin);

        // Calculate the total potential profit. Print value
        double totalProfit = profitMargin * productQuantity;
        System.out.println("The total Potential Profit is: " + totalProfit);
        
    }
}
