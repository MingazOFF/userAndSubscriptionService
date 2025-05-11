package ru.mingazoff.userAndSubscriptionService.controller.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ErrorMessage {

    private String errorMessage;

    private HttpStatus httpStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime errorTime;

    public ErrorMessage(String errorMessage, HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
        this.errorTime = LocalDateTime.now();
    }
}
