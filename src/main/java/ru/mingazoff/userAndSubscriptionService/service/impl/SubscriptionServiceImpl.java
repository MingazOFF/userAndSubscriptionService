package ru.mingazoff.userAndSubscriptionService.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mingazoff.userAndSubscriptionService.mapper.SubscriptionMapper;
import ru.mingazoff.userAndSubscriptionService.model.dto.SubscriptionDto;
import ru.mingazoff.userAndSubscriptionService.model.entity.Subscription;
import ru.mingazoff.userAndSubscriptionService.repository.SubscriptionRepository;
import ru.mingazoff.userAndSubscriptionService.service.SubscriptionService;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;

    @Override
    public SubscriptionDto getSubscriptionDtoById(Long id) {
        Subscription subscription = subscriptionRepository.findById(id).orElse(null);
        return subscriptionMapper.toSubscriptionDto(subscription);
    }

}
