package ru.mingazoff.userAndSubscriptionService.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Schema(description = "Объект передачи данных пользователя")
public class UserDto {

    @Length(min = 3, max = 50)
    @JsonProperty("name")
    @Schema(description = "Имя пользователя", example = "Гавриил Поликарпович")
    private String name;
}