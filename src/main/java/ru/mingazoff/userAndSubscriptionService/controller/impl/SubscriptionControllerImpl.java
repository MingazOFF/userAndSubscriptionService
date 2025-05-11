package ru.mingazoff.userAndSubscriptionService.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mingazoff.userAndSubscriptionService.controller.SubscriptionController;
import ru.mingazoff.userAndSubscriptionService.model.dto.SubscriptionDto;
import ru.mingazoff.userAndSubscriptionService.service.SubscriptionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SubscriptionControllerImpl implements SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Override
    public SubscriptionDto getSubscriptionById(Long id) {
        return subscriptionService.getSubscriptionDtoById(id);
    }

    @Override
    public List<SubscriptionDto> getTop3Subscriptions() {
        return subscriptionService.getTop3SubscriptionDtoList();
    }

}
