package org.example.fishingconfig47.exceptions;

public class FishingKitNotFoundException extends ResourceNotFoundException {
    public FishingKitNotFoundException(String message) {
        super(message);
    }

    public FishingKitNotFoundException() {
        super("Fishing Kit not found");
    }
}
