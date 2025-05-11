package ru.mingazoff.userAndSubscriptionService.service;

import ru.mingazoff.userAndSubscriptionService.model.dto.SubscriptionDto;
import ru.mingazoff.userAndSubscriptionService.model.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    SubscriptionDto getSubscriptionDtoById(Long id);

    Subscription getSubscriptionById(Long id);

    List<SubscriptionDto> getTop3SubscriptionDtoList();

    Subscription findOrCreateSubscription(SubscriptionDto subscriptionDto);
}

