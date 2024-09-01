package org.example.fishingconfig47.exceptions;

public class NotEnoughBudgetException extends ValidationException {
    public NotEnoughBudgetException(String message) {
        super(message);
    }

    public NotEnoughBudgetException() {
        super("Not enough budget");
    }
}
