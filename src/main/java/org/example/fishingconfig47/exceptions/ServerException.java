package org.example.fishingconfig47.exceptions;

public class ServerException extends RuntimeException {
    public ServerException(String message) {
        super(message);
    }

    public ServerException() {
        super("Internal server error");
    }
}
