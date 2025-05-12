package ru.mingazoff.userAndSubscriptionService.controller.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Schema(description = "Объект передачи ошибок")
public class ErrorResponse {

    @Schema(description = "Описание ошибки")
    private String errorMessage;
    @Schema(description = "Http статус ошибки")
    private HttpStatus httpStatus;

    @Schema(description = "Время ошибки")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime errorTime;

    public ErrorResponse(String errorMessage, HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
        this.errorTime = LocalDateTime.now();
    }
}
