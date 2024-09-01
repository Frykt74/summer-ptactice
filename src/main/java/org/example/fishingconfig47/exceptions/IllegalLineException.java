package org.example.fishingconfig47.exceptions;

public class IllegalLineException extends ValidationException {
    public IllegalLineException(String message) {
        super(message);
    }

    public IllegalLineException() {
        super("Illegal line");
    }
}
