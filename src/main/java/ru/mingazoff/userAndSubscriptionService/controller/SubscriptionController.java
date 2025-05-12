package ru.mingazoff.userAndSubscriptionService.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mingazoff.userAndSubscriptionService.model.dto.SubscriptionDto;

import java.util.List;

@Validated
@Tag(name = "Subscription API", description = "Сервис по управлению подписками")
@RequestMapping("/subscriptions")
public interface SubscriptionController {

    @Operation(
            summary = "Получить подписку",
            description = "Получение подписки из сервиса по его идентификатору"
    )
    @GetMapping(value = "/{id}")
    SubscriptionDto getSubscriptionById(@Parameter(description = "Идентификатор подписки",
            required = true, example = "2") @PathVariable("id") @Min(1) Long id);

    @Operation(
            summary = "Получить ТОП 3 подписок",
            description = "Получение самых популярных подписок"
    )
    @GetMapping(value = "/top")
    List<SubscriptionDto> getTop3Subscriptions();
}
