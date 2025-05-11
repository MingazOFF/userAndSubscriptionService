package ru.mingazoff.userAndSubscriptionService.controller;

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
@RequestMapping(value = "users/{id}/subscriptions")
public interface UserWithSubscriptionsController {

    @PostMapping()
    Long addSubscriptionToUser(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody SubscriptionDto subscriptionDto);

    @GetMapping()
    Set<SubscriptionDto> getUserSubscriptionsById(@PathVariable("id") @Min(1) Long id);

    @DeleteMapping("/{sub_id}")
    void deleteSubscriptionFromUserById(@PathVariable("id") @Min(1) Long id, @PathVariable("sub_id") @Min(1) Long subId);
}
