package ru.mingazoff.userAndSubscriptionService.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mingazoff.userAndSubscriptionService.model.dto.SubscriptionDto;

import java.util.Set;

@Validated
@Tag(name = "UserSubscription API", description = "Сервис по управлению подписками пользователя")
@RequestMapping(value = "users/{id}/subscriptions")
public interface UserWithSubscriptionsController {

    @Operation(
            summary = "Добавить подписку пользователю",
            description = "Создание подписки и добавление его к указанному пользователю"
    )
    @PostMapping()
    Long addSubscriptionToUser(@Parameter(description = "Идентификатор пользователя",
            required = true, example = "1") @PathVariable("id") @Min(1) Long id, @Valid @RequestBody SubscriptionDto subscriptionDto);

    @Operation(
            summary = "Получить подписки пользователей",
            description = "Получение всех подписок у пользователя"
    )
    @GetMapping()
    Set<SubscriptionDto> getUserSubscriptionsById(@Parameter(description = "Идентификатор пользователя",
            required = true, example = "5") @PathVariable("id") @Min(1) Long id);

    @Operation(
            summary = "Удалить подписку пользователя",
            description = "Удаление подписки у пользователя по его идентификатору"
    )
    @DeleteMapping("/{sub_id}")
    void deleteSubscriptionFromUserById(@Parameter(description = "Идентификатор пользователя",
            required = true, example = "7") @PathVariable("id") @Min(1) Long id, @Parameter(description = "Идентификатор подписки",
            required = true, example = "2") @PathVariable("sub_id") @Min(1) Long subId);
}
