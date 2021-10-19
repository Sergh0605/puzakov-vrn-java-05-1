package ru.dataart.academy.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class ReverseInteger {
    /**
     * @param inputNumber - any integer value
     * @return - inputNumber in reversed order
     * Example: 1234 -> 4321
     * -23 -> -32
     * 120 -> 21
     * -2,147,483,648 -> exception and error message
     * If result (number in reversed order) is out of int range [-2,147,483,648,  2,147,483,647] throw custom
     * unchecked exception. In main method (Main class) if exception happened output message with problem to user.
     */
    public int reverse(int inputNumber) {
        //Task implementation
        String negativePrefix = "";

        // Special cases check
        if (inputNumber < 10 && inputNumber > -10) return inputNumber;

        // main calculations
        LinkedList<String> listOfSymbols = new LinkedList<>(Arrays.asList(String.valueOf(inputNumber).split("")));
        if (inputNumber < 0) {
            negativePrefix = "-";
            listOfSymbols.removeFirst();
        }

        Collections.reverse(listOfSymbols);
        String reversedNumber = listOfSymbols.stream().collect(Collectors.joining("", negativePrefix, ""));

        try {
            return Integer.parseInt(reversedNumber);
        } catch (NumberFormatException e) {
            throw new OutOfIntegerRangeConversionException(reversedNumber);
        }
    }
}
