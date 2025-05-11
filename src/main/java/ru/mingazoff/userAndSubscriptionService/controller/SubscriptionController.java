package ru.mingazoff.userAndSubscriptionService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mingazoff.userAndSubscriptionService.model.dto.SubscriptionDto;

import java.util.List;

@RequestMapping("/subscriptions")
public interface SubscriptionController {

    @GetMapping(value = "/{id}")
    SubscriptionDto getSubscriptionById(@PathVariable("id") Long id);

    @GetMapping(value = "/top")
    List<SubscriptionDto> getTop3Subscriptions();
}
