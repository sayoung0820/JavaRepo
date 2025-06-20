package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) throws IllegalArgumentException, IllegalAccessException {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf("\n"); // Locates index of new line character, assigns it to variable
            String delimiter = numbers.substring(2, delimiterEnd); // Extracts a portion of the string, starting at index 2
            String numbersPart = numbers.substring(delimiterEnd + 1); // End plus 1 to account for index starting at 0

            String[] nums = numbersPart.split(delimiter); // Split by delimiter
            return getSum(nums);
        }

            String[] nums = numbers.split("[,\n]"); // Split by commas and newLines
            return getSum(nums);

        }

    private int getSum(String [] nums) throws IllegalAccessException {
        int sum = 0;
        List<Integer> negatives = new ArrayList<>(); // To store negative numbers


        for(String num:nums) {
            int parsedNum = Integer.parseInt(num.trim()); // Trim and parse the number
            if (parsedNum < 0) {
                negatives.add(parsedNum);
            }
            sum += parsedNum;
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives);
        }
        return sum;

    }
}


