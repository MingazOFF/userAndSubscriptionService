package ru.mingazoff.userAndSubscriptionService.controller.handler;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.mingazoff.userAndSubscriptionService.exception.SubscriptionNotBelongToUser;
import ru.mingazoff.userAndSubscriptionService.exception.SubscriptionNotFoundException;
import ru.mingazoff.userAndSubscriptionService.exception.UserNotFoundException;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler({SubscriptionNotFoundException.class, UserNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse entityNotFoundExceptionHandler(EntityNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND);
        log.info("Перехвачено исключение: {}, сообщение: {}", e.getClass(), errorResponse);
        return errorResponse;
    }

    @ExceptionHandler(SubscriptionNotBelongToUser.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public ErrorResponse entityNotFoundExceptionHandler(SubscriptionNotBelongToUser e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        log.info("Перехвачено исключение: {}, сообщение: {}", e.getClass(), errorResponse);
        return errorResponse;
    }


    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse ConstraintViolationExceptionHandler(ConstraintViolationException e) {
        String errorMessage = e.getConstraintViolations().stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .collect(Collectors.joining("; "));
        ErrorResponse errorResponse = new ErrorResponse(errorMessage, HttpStatus.BAD_REQUEST);
        log.info("Перехвачено исключение: {}, сообщение: {}", e.getClass(), errorResponse);
        return errorResponse;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String errorMessage = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));
        ErrorResponse errorResponse = new ErrorResponse(errorMessage, HttpStatus.BAD_REQUEST);
        log.info("Перехвачено исключение: {}, сообщение: {}", e.getClass(), errorResponse);
        return errorResponse;
    }


}
