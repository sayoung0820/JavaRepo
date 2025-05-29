public class ExerciseDataTypes {

    public static void main(String[] args) {

        String playerName = "Lionel Messi";
        String jerseyNumber = "10";
        String position = "Forward";
        Boolean isStarter = true;
        String teamName = "Inter Miami";
        System.out.println("Soccer Player " + playerName + " wears jersey number " + jerseyNumber +
                " and plays as a " + position + " for " + teamName + ".");

        jerseyNumber = "23";
        isStarter = false;
        System.out.println(jerseyNumber);
        System.out.println(isStarter);

        String movieTitle = "28 Weeks Later";
        String releaseYear = "2007";
        String rating = "R";
        Boolean isSequel = true;
        String leadActor = "Robert Carlyle";
        System.out.println("The movie " + movieTitle + " was released in " + releaseYear + " and stars " +
                leadActor + " and is rated " + rating + ".");

        rating = "PG 13";
        isSequel = false;
        System.out.println(rating);
        System.out.println(isSequel);

        String city = "Atlanta";
        int temperature = 70;
        Boolean isRaining = true;
        float humidity = 0.89F;
        String weatherCondition = "Cloudy";
        System.out.println("Weather Report: " + city + " has a temperature of " + temperature + "*F with " +
                humidity + "% humidity " + "and " + weatherCondition + " conditions " + ".");

        temperature = 90;
        weatherCondition = "Sunny";
        System.out.println(temperature);
        System.out.println(weatherCondition);

        String flightNumber = "AA256";
        String departureCity = "Atlanta";
        String arrivalCity = "Chicago";
        String gateNumber = "C21";
        String terminal = "E";
        Boolean isDelayed = false;
        System.out.println("Flight number " + flightNumber + " departing gate number " + gateNumber
                + " in terminal " + terminal + " out of " + departureCity + " and arriving in " + arrivalCity
                + " will not be delayed " + ".");

        gateNumber = "D7";
        isDelayed = true;
        System.out.println(gateNumber);
        System.out.println(isDelayed);

        Boolean hasHomework = true;
        Boolean isWeekend = false;
        Boolean attendedClass = true;
        System.out.println("Do I have homework? " + hasHomework);
        System.out.println("Is it the weekend? " + isWeekend);
        System.out.println("Did I attend class today? " + attendedClass);

        char firstInitial = 'S';
        char lastInitial = 'Y';
        char favGrade = 'A';
        System.out.println("My first initial is " + firstInitial + " and my last initial is " + lastInitial
        + " and my favorite letter grade is " + favGrade + ".");










    }
}
