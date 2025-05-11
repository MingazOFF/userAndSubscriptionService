package ru.mingazoff.userAndSubscriptionService.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserDto {

    @Length(min = 3, max = 50)
    @JsonProperty("name")
    private String name;
}