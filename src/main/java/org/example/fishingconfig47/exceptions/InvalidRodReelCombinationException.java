package org.example.fishingconfig47.exceptions;

public class InvalidRodReelCombinationException extends ValidationException {

    public InvalidRodReelCombinationException(String message) {
        super(message);
    }

    public InvalidRodReelCombinationException() {
        super("Invalid combination rod and reel ");
    }
}
