package ru.mingazoff.userAndSubscriptionService.controller.handler;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.mingazoff.userAndSubscriptionService.exception.SubscriptionNotBelongToUser;
import ru.mingazoff.userAndSubscriptionService.exception.SubscriptionNotFoundException;
import ru.mingazoff.userAndSubscriptionService.exception.UserNotFoundException;

@RestControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler({SubscriptionNotFoundException.class, UserNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage entityNotFoundExceptionHandler(EntityNotFoundException e) {
        return new ErrorMessage(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SubscriptionNotBelongToUser.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public ErrorMessage entityNotFoundExceptionHandler(SubscriptionNotBelongToUser e) {
        return new ErrorMessage(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
    }

}
