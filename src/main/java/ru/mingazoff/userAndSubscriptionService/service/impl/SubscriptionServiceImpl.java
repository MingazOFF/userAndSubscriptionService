package ru.mingazoff.userAndSubscriptionService.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mingazoff.userAndSubscriptionService.mapper.SubscriptionMapper;
import ru.mingazoff.userAndSubscriptionService.model.dto.SubscriptionDto;
import ru.mingazoff.userAndSubscriptionService.model.entity.Subscription;
import ru.mingazoff.userAndSubscriptionService.repository.SubscriptionRepository;
import ru.mingazoff.userAndSubscriptionService.service.SubscriptionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;

    @Override
    public SubscriptionDto getSubscriptionDtoById(Long id) {
        return subscriptionMapper.toSubscriptionDto(getSubscriptionById(id));
    }

    @Override
    public Subscription getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id).orElse(null);
    }

    @Override
    public Subscription findOrCreateSubscription(SubscriptionDto subscriptionDto) {
        if (subscriptionRepository.findByName(subscriptionDto.getName()).isPresent()) {
            return subscriptionRepository.findByName(subscriptionDto.getName()).get();
        }
        Subscription subscription = subscriptionMapper.toSubscription(subscriptionDto);
        return subscriptionRepository.save(subscription);
    }

    @Override
    public List<SubscriptionDto> getTop3SubscriptionDtoList() {
        List<SubscriptionDto> subscriptionDtos = subscriptionRepository.findTop3Subscriptions().stream()
                .map(subscriptionMapper::toSubscriptionDto).toList();
        return subscriptionDtos;
    }

}
