package ru.mingazoff.userAndSubscriptionService.exception;

import jakarta.persistence.EntityNotFoundException;

public class SubscriptionNotBelongToUser extends EntityNotFoundException {
    public SubscriptionNotBelongToUser(String message) {
        super(message);
    }
}
