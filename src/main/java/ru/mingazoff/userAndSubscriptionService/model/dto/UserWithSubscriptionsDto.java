package ru.mingazoff.userAndSubscriptionService.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
public class UserWithSubscriptionsDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("subscriptions")
    private Set<SubscriptionDto> subscriptions;
}
