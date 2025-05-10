package ru.mingazoff.userAndSubscriptionService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mingazoff.userAndSubscriptionService.model.dto.UserDto;
import ru.mingazoff.userAndSubscriptionService.service.UserService;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/{id}")
    public UserDto getUserById(@PathVariable("id") Long id) {
        return userService.getUserDtoById(id);
    }

    @PostMapping(value = "")
    public Long createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }
}
