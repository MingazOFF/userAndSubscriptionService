package ru.mingazoff.userAndSubscriptionService.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Data
public class UserWithSubscriptionsDto {

    @Length(min = 3, max = 50)
    @JsonProperty("name")
    private String name;

    @JsonProperty("subscriptions")
    private Set<SubscriptionDto> subscriptions;
}
