package ru.mingazoff.userAndSubscriptionService.controller;

import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mingazoff.userAndSubscriptionService.model.dto.SubscriptionDto;

import java.util.List;

@Validated
@RequestMapping("/subscriptions")
public interface SubscriptionController {

    @GetMapping(value = "/{id}")
    SubscriptionDto getSubscriptionById(@PathVariable("id") @Min(1) Long id);

    @GetMapping(value = "/top")
    List<SubscriptionDto> getTop3Subscriptions();
}
