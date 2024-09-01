package org.example.fishingconfig47.exceptions;

public class IllegalFishCountException extends ValidationException {
    public IllegalFishCountException(String message) {
        super(message);
    }

    public IllegalFishCountException() {
        super("Illegal fish count");
    }
}
