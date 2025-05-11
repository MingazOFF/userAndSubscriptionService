package ru.mingazoff.userAndSubscriptionService.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mingazoff.userAndSubscriptionService.controller.UserController;
import ru.mingazoff.userAndSubscriptionService.model.dto.UserDto;
import ru.mingazoff.userAndSubscriptionService.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public Long createUser(UserDto userDto) {
        return userService.createUser(userDto);
    }

    @Override
    public UserDto getUserById(Long id) {
        return userService.getUserDtoById(id);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @Override
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

}
