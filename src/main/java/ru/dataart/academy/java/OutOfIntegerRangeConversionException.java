package ru.dataart.academy.java;

public class OutOfIntegerRangeConversionException extends RuntimeException {
    public OutOfIntegerRangeConversionException(String numberForConversion) {
        super("Can't convert to int. " + numberForConversion + " is out of Integer range.");
    }
}
