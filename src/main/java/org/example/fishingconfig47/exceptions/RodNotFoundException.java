package org.example.fishingconfig47.exceptions;

public class RodNotFoundException extends ResourceNotFoundException {

    public RodNotFoundException(String message) {
        super(message);
    }

    public RodNotFoundException(Integer id) {
        super("Rod with id " + id + " not found");
    }
}
