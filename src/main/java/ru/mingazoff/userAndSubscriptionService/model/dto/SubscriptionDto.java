package ru.mingazoff.userAndSubscriptionService.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class SubscriptionDto {

    @Length(min = 2, max = 100)
    @JsonProperty("name")
    private String name;
}
