package ru.mingazoff.userAndSubscriptionService.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Schema(description = "Объект передачи данных подписки")
public class SubscriptionDto {

    @Length(min = 2, max = 100)
    @JsonProperty("name")
    @Schema(description = "Название подписки", example = "Premier")
    private String name;
}
