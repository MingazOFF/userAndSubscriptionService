package ru.mingazoff.userAndSubscriptionService.model.dto;

import lombok.Data;
import java.util.Set;

@Data
public class UserWithSubscriptionsDto {
    private String name;

    private Set<SubscriptionDto> subscriptions;
}
