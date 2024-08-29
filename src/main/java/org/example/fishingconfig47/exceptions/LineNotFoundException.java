package org.example.fishingconfig47.exceptions;

public class LineNotFoundException extends ResourceNotFoundException {

    public LineNotFoundException(String message) {
        super(message);
    }

    public LineNotFoundException(Integer id) {
        super("Line with id " + id + " not found");
    }
}
