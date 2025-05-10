package ru.mingazoff.userAndSubscriptionService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mingazoff.userAndSubscriptionService.model.dto.UserWithSubscriptionsDto;
import ru.mingazoff.userAndSubscriptionService.service.UserService;

@RestController
@RequestMapping(value = "users/{id}/subscriptions")
@RequiredArgsConstructor
public class UserWithSubscriptionsController {
    private final UserService userService;

    @GetMapping()
    public UserWithSubscriptionsDto getUserWithSubscriptions(@PathVariable("id") Long id) {
        return userService.getUserWithSubscriptionsDtoById(id);
    }
}
