package org.example.fishingconfig47.exceptions;

public class IllegalLureException extends ValidationException {
    public IllegalLureException(String message) {
        super(message);
    }

    public IllegalLureException() {
        super("Illegal lure");
    }
}
