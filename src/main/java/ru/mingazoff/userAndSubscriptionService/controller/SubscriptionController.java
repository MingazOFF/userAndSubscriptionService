package ru.mingazoff.userAndSubscriptionService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mingazoff.userAndSubscriptionService.model.dto.SubscriptionDto;
import ru.mingazoff.userAndSubscriptionService.service.SubscriptionService;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @GetMapping(value = "/{id}")
    public SubscriptionDto getSubscriptionById(@PathVariable("id") Long id) {
        return subscriptionService.getSubscriptionDtoById(id);
    }

    @GetMapping(value = "/top")
    public List<SubscriptionDto> getTop3Subscriptions() {
        return subscriptionService.getTop3SubscriptionDtoList();
    }

}
