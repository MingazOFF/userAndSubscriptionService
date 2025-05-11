package ru.mingazoff.userAndSubscriptionService.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mingazoff.userAndSubscriptionService.model.dto.SubscriptionDto;

import java.util.Set;

@RequestMapping(value = "users/{id}/subscriptions")
public interface UserWithSubscriptionsController {

    @PostMapping()
    Long addSubscriptionToUser(@PathVariable("id") Long id, @RequestBody SubscriptionDto subscriptionDto);

    @GetMapping()
    Set<SubscriptionDto> getUserSubscriptionsById(@PathVariable("id") Long id);

    @DeleteMapping("/{sub_id}")
    void deleteSubscriptionFromUserById(@PathVariable("id") Long id, @PathVariable("sub_id") Long subId);
}
