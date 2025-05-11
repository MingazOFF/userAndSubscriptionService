package ru.mingazoff.userAndSubscriptionService.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mingazoff.userAndSubscriptionService.model.dto.UserDto;

@RequestMapping(value = "/users")
public interface UserController {

    @PostMapping(value = "")
    Long createUser(@RequestBody UserDto userDto);

    @GetMapping(value = "/{id}")
    UserDto getUserById(@PathVariable("id") Long id);

    @PutMapping(value = "/{id}")
    UserDto updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto);

    @DeleteMapping(value = "/{id}")
    void deleteUser(@PathVariable("id") Long id);

}
