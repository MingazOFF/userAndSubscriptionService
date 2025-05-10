package ru.mingazoff.userAndSubscriptionService.mapper;

import org.mapstruct.Mapper;
import ru.mingazoff.userAndSubscriptionService.model.dto.SubscriptionDto;
import ru.mingazoff.userAndSubscriptionService.model.entity.Subscription;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {
    SubscriptionDto toSubscriptionDto(Subscription subscription);

    Subscription toSubscription(SubscriptionDto subscriptionDto);
}
