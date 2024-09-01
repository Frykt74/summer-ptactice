package org.example.fishingconfig47.exceptions;

public class ReelNotFoundException extends ResourceNotFoundException {

    public ReelNotFoundException(String message) {
        super(message);
    }

    public ReelNotFoundException(Integer id) {
        super("Reel with id " + id + " not found");
    }

    public ReelNotFoundException() {
        super("Reel not found");
    }
}
