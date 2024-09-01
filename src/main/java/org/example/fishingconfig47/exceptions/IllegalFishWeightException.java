package org.example.fishingconfig47.exceptions;

public class IllegalFishWeightException extends ValidationException {
    public IllegalFishWeightException(String message) {
        super(message);
    }

    public IllegalFishWeightException() {
        super("Illegal fish weight");
    }
}
