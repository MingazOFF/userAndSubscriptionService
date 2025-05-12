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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mingazoff.userAndSubscriptionService.model.dto.UserDto;

@Validated
@Tag(name = "User API", description = "Сервис по управлению пользователями")
@RequestMapping(value = "/users")
public interface UserController {

    @Operation(
            summary = "Создать пользователя",
            description = "Создание пользователя и добавление его в сервис"
    )
    @PostMapping(value = "")
    Long createUser(@Valid @RequestBody UserDto userDto);

    @Operation(
            summary = "Получить пользователя",
            description = "Получение пользователя из сервиса по его идентификатору"
    )
    @GetMapping(value = "/{id}")
    UserDto getUserById(@Parameter(description = "Идентификатор пользователя",
            required = true, example = "13") @PathVariable("id") @Min(1) Long id);

    @Operation(
            summary = "Обновить пользователя",
            description = "Обновление пользователя в сервисе по его идентификатору"
    )
    @PutMapping(value = "/{id}")
    UserDto updateUser(@Parameter(description = "Идентификатор пользователя",
            required = true, example = "9") @PathVariable("id") @Min(1) Long id, @Valid @RequestBody UserDto userDto);

    @Operation(
            summary = "Удалить пользователя",
            description = "Удаление пользователя из сервиса по его идентификатору"
    )
    @DeleteMapping(value = "/{id}")
    void deleteUser(@Parameter(description = "Идентификатор пользователя",
            required = true, example = "3") @PathVariable("id") @Min(1) Long id);

}
