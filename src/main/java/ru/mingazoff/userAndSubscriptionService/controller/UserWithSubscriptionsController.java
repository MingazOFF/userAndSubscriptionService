package ru.mingazoff.userAndSubscriptionService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mingazoff.userAndSubscriptionService.model.dto.SubscriptionDto;
import ru.mingazoff.userAndSubscriptionService.service.UserService;

import java.util.Set;

@RestController
@RequestMapping(value = "users/{id}/subscriptions")
@RequiredArgsConstructor
public class UserWithSubscriptionsController {

    private final UserService userService;

    @PostMapping()
    public Long addSubscriptionToUser(@PathVariable("id") Long id, @RequestBody SubscriptionDto subscriptionDto) {
        return userService.addSubscriptionToUser(id, subscriptionDto);
    }

    @GetMapping()
    public Set<SubscriptionDto> getUserSubscriptionsById(@PathVariable("id") Long id) {
        return userService.getUserWithSubscriptionsDtoById(id).getSubscriptions();
    }

    @DeleteMapping("/{sub_id}")
    public void deleteSubscriptionFromUserById(@PathVariable("id") Long id, @PathVariable("sub_id") Long subId) {
        userService.deleteSubscriptionFromUserById(id, subId);
    }
}
