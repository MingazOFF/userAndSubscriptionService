package ru.mingazoff.userAndSubscriptionService.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SubscriptionDto {

    @JsonProperty("name")
    private String name;
}
