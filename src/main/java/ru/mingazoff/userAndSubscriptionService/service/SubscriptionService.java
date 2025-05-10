package ru.mingazoff.userAndSubscriptionService.service;

import ru.mingazoff.userAndSubscriptionService.model.dto.SubscriptionDto;

public interface SubscriptionService {
    SubscriptionDto getSubscriptionDtoById(Long id);
}
