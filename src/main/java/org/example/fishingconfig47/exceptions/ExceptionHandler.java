package org.example.fishingconfig47.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(RodNotFoundException.class)
    public ResponseEntity<String> handleRodNotFoundException(RodNotFoundException e) {
        return new ResponseEntity<>("Rod Not Found", HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ReelNotFoundException.class)
    public ResponseEntity<String> handleReelNotFoundException(ReelNotFoundException e) {
        return new ResponseEntity<>("Reel Not Found", HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(LureNotFoundException.class)
    public ResponseEntity<String> handleReelNotFoundException(LureNotFoundException e) {
        return new ResponseEntity<>("Lure Not Found", HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(LineNotFoundException.class)
    public ResponseEntity<String> handleReelNotFoundException(LineNotFoundException e) {
        return new ResponseEntity<>("Line Not Found", HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(FishingKitNotFoundException.class)
    public ResponseEntity<String> handleReelNotFoundException(FishingKitNotFoundException e) {
        return new ResponseEntity<>("Kit Not Found", HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidRodReelCombinationException.class)
    public ResponseEntity<String> handleInvalidRodReelCombinationException(InvalidRodReelCombinationException e) {
        return new ResponseEntity<>("Катушка не подходит к удилищу", HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalLineException.class)
    public ResponseEntity<String> handleIllegalLineException(IllegalLineException e) {
        return new ResponseEntity<>("Нагрузка лески не должна превышать мощность фрикциона", HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalNameException.class)
    public ResponseEntity<String> handleIllegalNameException(IllegalNameException e) {
        return new ResponseEntity<>("У набора должно быть название", HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalLureException.class)
    public ResponseEntity<String> handleIllegalLureException(IllegalLureException e) {
        return new ResponseEntity<>("Масса приманки должна быть в диапазоне теста удилища", HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalFishWeightException.class)
    public ResponseEntity<String> handleIllegalFishWeightException(IllegalFishWeightException e) {
        return new ResponseEntity<>("Вес рыбы не может быть отрицательным", HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalFishCountException.class)
    public ResponseEntity<String> handleIllegalFishCountException(IllegalFishCountException e) {
        return new ResponseEntity<>("Количество рыб не может быть отрицательным", HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NotEnoughBudgetException.class)
    public ResponseEntity<String> handleNotEnoughBudgetException(NotEnoughBudgetException e) {
        return new ResponseEntity<>("Не хватает средств для покупки", HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ServerException.class)
    public ResponseEntity<String> handleServerException(ServerException e) {
        return new ResponseEntity<>("Неожиданная ошибка. Попробуйте немного увеличить бюджет", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
