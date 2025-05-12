package ru.mingazoff.userAndSubscriptionService.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Data
@Schema(description = "Объект передачи данных пользователя и его подписок")
public class UserWithSubscriptionsDto {

    @Length(min = 3, max = 50)
    @JsonProperty("name")
    @Schema(description = "Имя пользователя", example = "Стас Космос")
    private String name;

    @JsonProperty("subscriptions")
    @Schema(description = "Подписки пользователя")
    private Set<SubscriptionDto> subscriptions;
}
