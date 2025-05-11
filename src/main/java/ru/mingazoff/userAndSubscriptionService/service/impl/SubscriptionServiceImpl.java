package ru.mingazoff.userAndSubscriptionService.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mingazoff.userAndSubscriptionService.exception.SubscriptionNotFoundException;
import ru.mingazoff.userAndSubscriptionService.mapper.SubscriptionMapper;
import ru.mingazoff.userAndSubscriptionService.model.dto.SubscriptionDto;
import ru.mingazoff.userAndSubscriptionService.model.entity.Subscription;
import ru.mingazoff.userAndSubscriptionService.repository.SubscriptionRepository;
import ru.mingazoff.userAndSubscriptionService.service.SubscriptionService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;

    @Override
    public SubscriptionDto getSubscriptionDtoById(Long id) {
        SubscriptionDto subscriptionDto = subscriptionMapper.toSubscriptionDto(getSubscriptionById(id));
        log.debug("Выполнен маппинг в DTO: {}", subscriptionDto);
        return subscriptionDto;
    }

    @Override
    public Subscription getSubscriptionById(Long id) {
        Subscription subscription = subscriptionRepository.findById(id).orElseThrow(
                () -> new SubscriptionNotFoundException(String.format("Подписка с id: %s не найдена", id)));
        log.info("Выполнено извлечение из БД по id: {} подписки: {}", id, subscription);
        return subscription;
    }

    public Subscription getSubscriptionByName(String name) {
        Subscription subscription = subscriptionRepository.findByName(name).orElseThrow(
                () -> new SubscriptionNotFoundException(String.format("Подписка с name: %s не найдена", name)));
        log.info("Выполнено извлечение из БД по name: {} подписки: {}", name, subscription);
        return subscription;
    }

    @Override
    public Subscription findOrCreateSubscription(SubscriptionDto subscriptionDto) {
        try {
            return getSubscriptionByName(subscriptionDto.getName());
        } catch (SubscriptionNotFoundException e) {
            Subscription newSubscription = subscriptionMapper.toSubscription(subscriptionDto);
            Subscription savedSubscription = subscriptionRepository.save(newSubscription);
            log.info("Выполнено сохранение в БД подписки: {}", savedSubscription);
            return savedSubscription;
        }
    }

    @Override
    public List<SubscriptionDto> getTop3SubscriptionDtoList() {
        List<Subscription> subscriptionList = subscriptionRepository.findTop3Subscriptions();
        log.info("Выполнено извлечение из БД подписок: {}", subscriptionList);
        List<SubscriptionDto> subscriptionDtoList = subscriptionList.stream()
                .map(subscriptionMapper::toSubscriptionDto).toList();
        log.debug("Выполнен маппинг списка в DTO: {}", subscriptionDtoList);
        return subscriptionDtoList;
    }

}
