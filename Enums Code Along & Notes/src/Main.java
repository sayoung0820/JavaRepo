public class Main {
    enum OrderStatus {
        ORDERED,
        WAREHOUSE,
        SHIPPED,
        DELIVERED,
        RETURNED
    }
    public static void main(String[] args) {
        // order status, 1 ordered, 2 warehouse, 2 shipped, 4 delivered, 5 returned
        // enums need to be declared outside functions

        OrderStatus status = OrderStatus.WAREHOUSE;


        if(status == OrderStatus.WAREHOUSE) {

        }
    }
}
