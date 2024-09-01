package org.example.fishingconfig47.exceptions;

public class LureNotFoundException extends ResourceNotFoundException {

    public LureNotFoundException(String message) {
        super(message);
    }

    public LureNotFoundException(Integer id) {
        super("Lure with id " + id + " not found");
    }

    public LureNotFoundException() {
        super("Lure not found");
    }
}
