package org.example.fishingconfig47.exceptions;

public class IllegalNameException extends ValidationException {
    public IllegalNameException(String message) {
        super(message);
    }

    public IllegalNameException() {
        super("Illegal Name");
    }
}
