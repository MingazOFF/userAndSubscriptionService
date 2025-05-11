package ru.mingazoff.userAndSubscriptionService.controller;

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
@RequestMapping(value = "/users")
public interface UserController {

    @PostMapping(value = "")
    Long createUser(@Valid @RequestBody UserDto userDto);

    @GetMapping(value = "/{id}")
    UserDto getUserById(@PathVariable("id") @Min(1) Long id);

    @PutMapping(value = "/{id}")
    UserDto updateUser(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody UserDto userDto);

    @DeleteMapping(value = "/{id}")
    void deleteUser(@PathVariable("id") @Min(1) Long id);

}
