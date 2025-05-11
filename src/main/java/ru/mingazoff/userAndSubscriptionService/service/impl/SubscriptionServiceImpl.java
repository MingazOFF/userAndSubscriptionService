package ru.mingazoff.userAndSubscriptionService.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mingazoff.userAndSubscriptionService.exception.SubscriptionNotFoundException;
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
        SubscriptionDto subscriptionDto = subscriptionMapper.toSubscriptionDto(getSubscriptionById(id));
        return subscriptionDto;
    }

    @Override
    public Subscription getSubscriptionById(Long id) {
        Subscription subscription = subscriptionRepository.findById(id).orElseThrow(
                () -> new SubscriptionNotFoundException(String.format("Подписка с id: %s не найдена", id)));
        return subscription;
    }

    public Subscription getSubscriptionByName(String name) {
        Subscription subscription = subscriptionRepository.findByName(name).orElseThrow(
                () -> new SubscriptionNotFoundException(String.format("Подписка с name: %s не найдена", name)));
        return subscription;
    }

    @Override
    public Subscription findOrCreateSubscription(SubscriptionDto subscriptionDto) {
        try {
            Subscription existsSubscription = getSubscriptionByName(subscriptionDto.getName());
            return existsSubscription;
        } catch (SubscriptionNotFoundException e) {
            Subscription newSubscription = subscriptionMapper.toSubscription(subscriptionDto);
            Subscription savedSubscription = subscriptionRepository.save(newSubscription);
            return savedSubscription;
        }
    }

    @Override
    public List<SubscriptionDto> getTop3SubscriptionDtoList() {
        List<SubscriptionDto> subscriptionDtoList = subscriptionRepository.findTop3Subscriptions().stream()
                .map(subscriptionMapper::toSubscriptionDto).toList();
        return subscriptionDtoList;
    }

}
