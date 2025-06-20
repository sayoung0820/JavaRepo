package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {
    private StringCalculator calc;

    @BeforeEach
    void setup() {
        calc = new StringCalculator();
    }

    @Test
    @DisplayName("Empty String returns zero")
    void emptyStringReturnsZero() throws IllegalAccessException {
        // Simulating adding 0, empty string
        int actual = calc.add("");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test to handle an unknown amount numbers")
    void testUnknownNumbers() throws IllegalAccessException {
        // Simulate an "unknown" number of inputs
        String numbers = "10,20,30,40";
        int expected = 100;
        // Calls the add method with the numbers
        int actual = calc.add(numbers);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test to allow Add method to handle new lines between numbers ")
    void testNewLineBetweenNumbers() throws IllegalAccessException {
        String numbers = "1\n2,3";
        int expected = 6;
        int actual = calc.add(numbers);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test to Support Custom Delimiters")
    void testForDifferentDelimiters() throws IllegalAccessException {
        String number = "//;\n1;2;5"; //Customer delimiter is ';'
        int expected = 8;
        int actual = calc.add(number);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test to throw exception when negative numbers are passed")
    void noNegatives() {
        String numbers = "1, -2, 3";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.add(numbers);
        });

        String expectedMessage = "negatives not allowed: [-2]";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Test to throw exception with multiple negative numbers")
    void multipleNegatives() {
        String numbers = "-1, -2, -3, -4";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.add(numbers);
        });

        String expectedMessage = "negatives not allowed: [-1, -2, -3, -4]";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage),
                "Expected exception message to contain: " + expectedMessage + ", but got: " + actualMessage);
    }






}



















