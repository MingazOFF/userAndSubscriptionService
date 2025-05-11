package ru.mingazoff.userAndSubscriptionService.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.mingazoff.userAndSubscriptionService.controller.UserWithSubscriptionsController;
import ru.mingazoff.userAndSubscriptionService.model.dto.SubscriptionDto;
import ru.mingazoff.userAndSubscriptionService.service.UserService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class UserWithSubscriptionsControllerImpl implements UserWithSubscriptionsController {

    private final UserService userService;

    public Long addSubscriptionToUser(Long id, SubscriptionDto subscriptionDto) {
        return userService.addSubscriptionToUser(id, subscriptionDto);
    }

    public Set<SubscriptionDto> getUserSubscriptionsById(@PathVariable("id") Long id) {
        return userService.getUserWithSubscriptionsDtoById(id).getSubscriptions();
    }

    public void deleteSubscriptionFromUserById(Long id, Long subId) {
        userService.deleteSubscriptionFromUserById(id, subId);
    }
}
