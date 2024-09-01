package org.example.fishingconfig47.exceptions;

public class FishingKitNotFoundException extends ResourceNotFoundException {
    public FishingKitNotFoundException(String message) {
        super(message);
    }

    public FishingKitNotFoundException() {
        super("Fishing Kit not found");
    }

    public FishingKitNotFoundException(Integer id) {
        super("Fishing Kit with id " + id + " not found");
    }
}
