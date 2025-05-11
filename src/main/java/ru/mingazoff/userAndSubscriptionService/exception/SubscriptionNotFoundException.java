package ru.mingazoff.userAndSubscriptionService.exception;

import jakarta.persistence.EntityNotFoundException;

public class SubscriptionNotFoundException extends EntityNotFoundException {
    public SubscriptionNotFoundException(String message) {
        super(message);
    }
}
