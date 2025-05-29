public class Main {
    public static void main(String[] args) {


        // Declare and assign variables
        double temperatureCelsius = 25.0;
        boolean isRaining = false;
        int windSpeedKmh = 10;

        // Convert Celsius to Fahrenheit using formula
        double temperatureFahrenheit = (temperatureCelsius * 9 / 5) + 32;

        // Use Assignment Operators
        // Increase temp by 5 degrees
        temperatureFahrenheit += 5.0;
        // Increase wind speed by 5km/h
        windSpeedKmh += 5;

        // Recalculate new temp after increase
        temperatureFahrenheit = (temperatureCelsius * 9 / 5) + 32;

        // Use comparison operators
        // check if temp in F exceeds 85F
        boolean isTempHigh = temperatureFahrenheit > 85;
        boolean isWindHigh = windSpeedKmh > 20;

        // Use logical operators
        // Determine if it's not raining AND temperature between 60-85 degrees F
        boolean isNotRaining = !isRaining;
        boolean isWarmEnough = temperatureFahrenheit >= 60;
        boolean isNotTooHot = temperatureFahrenheit <= 85;
        boolean isGoodDay = isNotRaining && isWarmEnough && isNotTooHot;
        boolean hasWeatherWarning = windSpeedKmh > 30 || temperatureCelsius < 0;

        System.out.println("Weather Report: ");
        System.out.println("--------------------------------");
        System.out.println("Temperature (Celsius): " + temperatureCelsius + "C");
        System.out.println("Temperature (Fahrenheit): " + temperatureFahrenheit + "F");
        System.out.println("Is it raining? " + isRaining);
        System.out.println("Wind Speed: " + windSpeedKmh + "km/h");
        System.out.println();

        System.out.println("Is it hot outside (> 85F)? " + isTempHigh);
        System.out.println("Is it windy (> 20 km/h)? " + isWindHigh);
        System.out.println("Is it a nice day to go outside? " + isGoodDay);
        System.out.println("Is there a weather warning? " + hasWeatherWarning);







    }
}
