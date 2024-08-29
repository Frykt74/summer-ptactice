package org.example.fishingconfig47.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ServerException.class)
    public ResponseEntity<String> handleServerException(ServerException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RodNotFoundException.class)
    public ResponseEntity<String> handleRodNotFoundException(RodNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ReelNotFoundException.class)
    public ResponseEntity<String> handleReelNotFoundException(ReelNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(LureNotFoundException.class)
    public ResponseEntity<String> handleReelNotFoundException(LureNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(LineNotFoundException.class)
    public ResponseEntity<String> handleReelNotFoundException(LineNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(FishingKitNotFoundException.class)
    public ResponseEntity<String> handleReelNotFoundException(FishingKitNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidRodReelCombinationException.class)
    public ResponseEntity<String> handleInvalidRodReelCombinationException(InvalidRodReelCombinationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalLineException.class)
    public ResponseEntity<String> handleIllegalLineException(IllegalLineException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalNameException.class)
    public ResponseEntity<String> handleIllegalNameException(IllegalNameException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalLureException.class)
    public ResponseEntity<String> handleIllegalLureException(IllegalLureException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalFishWeightException.class)
    public ResponseEntity<String> handleIllegalFishWeightException(IllegalFishWeightException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalFishCountException.class)
    public ResponseEntity<String> handleIllegalFishCountException(IllegalFishCountException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NotEnoughBudgetException.class)
    public ResponseEntity<String> handleNotEnoughBudgetException(NotEnoughBudgetException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
