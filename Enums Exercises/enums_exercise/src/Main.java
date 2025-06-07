public class Main {
    enum CoffeeSize {
        SMALL,
        MEDIUM,
        LARGE
        }

    enum SeatSelection {
        GENERAL,
        PREMIUM,
        VIP
    }

    public static void main(String[] args) {

        CoffeeSize coffeOrder = CoffeeSize.LARGE;
        System.out.println(coffeOrder);

        SeatSelection seats = SeatSelection.GENERAL;
        SeatSelection seats2 = SeatSelection.PREMIUM;
        SeatSelection seats3 = SeatSelection.VIP;

        System.out.println("General is assigned value: " + seats.ordinal());
        System.out.println("Premium is assigned value: " + seats2.ordinal());
        System.out.println("VIP is assigned value: " + seats3.ordinal());

        enum TrafficLight {
            RED,
            YELLOW,
            GREEN
        }

        TrafficLight[] lights = TrafficLight.values();
        System.out.println(lights[1]);

        enum Weekday {
            MONDAY,
            TUESDAY,
            WEDNESDAY,
            THURSDAY,
            FRIDAY,
            SATURDAY,
            SUNDAY
        }

        Weekday workday = Weekday.WEDNESDAY;
        System.out.println("The workday is: " + workday);

        if (workday == Weekday.SATURDAY || workday == Weekday.SUNDAY); {
            System.out.println(workday + " is a workday.");
        }
        
        enum AlertLevel {
            LOW,
            MODERATE,
            HIGH,
            SEVERE
        }

        AlertLevel alert = AlertLevel.HIGH;
        System.out.println("The Alert Level is: " + alert);
        switch (alert) {
            case LOW:
                System.out.println("NO immediate danger. ");
                break;
            case MODERATE:
                System.out.println("Stay alert and aware. ");
                break;
            case HIGH:
                System.out.println("Take precautions and stay informed. ");
                break;
            case SEVERE:
                System.out.println("Immediate action required! ");
                break;

        }






            }

    }



