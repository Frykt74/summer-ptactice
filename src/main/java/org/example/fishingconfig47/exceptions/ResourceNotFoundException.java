package org.example.fishingconfig47.exceptions;

public class ResourceNotFoundException extends ServerException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException() {
        super("Not Found");
    }
}
