package ru.mingazoff.userAndSubscriptionService.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mingazoff.userAndSubscriptionService.exception.SubscriptionNotBelongToUser;
import ru.mingazoff.userAndSubscriptionService.exception.UserNotFoundException;
import ru.mingazoff.userAndSubscriptionService.mapper.UserMapper;
import ru.mingazoff.userAndSubscriptionService.mapper.UserWithSubscriptionsMapper;
import ru.mingazoff.userAndSubscriptionService.model.dto.SubscriptionDto;
import ru.mingazoff.userAndSubscriptionService.model.dto.UserDto;
import ru.mingazoff.userAndSubscriptionService.model.dto.UserWithSubscriptionsDto;
import ru.mingazoff.userAndSubscriptionService.model.entity.Subscription;
import ru.mingazoff.userAndSubscriptionService.model.entity.User;
import ru.mingazoff.userAndSubscriptionService.repository.UserRepository;
import ru.mingazoff.userAndSubscriptionService.service.SubscriptionService;
import ru.mingazoff.userAndSubscriptionService.service.UserService;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserWithSubscriptionsMapper userWithSubscriptionsMapper;
    private final SubscriptionService subscriptionService;

    private User getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException(String.format("Пользователь с id: %s не найден", id)));
        log.info("Выполнено извлечение из БД по id: {} пользователя: {}", id, user);
        return user;
    }

    @Override
    public UserDto getUserDtoById(Long id) {
        UserDto userDto = userMapper.toUserDto(getUserById(id));
        log.debug("Выполнен маппинг в DTO: {}", userDto);
        return userDto;
    }

    @Override
    public UserWithSubscriptionsDto getUserWithSubscriptionsDtoById(Long id) {
        UserWithSubscriptionsDto userDto = userWithSubscriptionsMapper.toUserWithSubscriptionsDto(getUserById(id));
        log.debug("Выполнен  маппинг в DTO: {}", userDto);
        return userDto;
    }

    @Override
    public Long createUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        User savedUser = userRepository.save(user);
        log.info("Выполнено сохранение в БД пользователя: {}", savedUser);
        return savedUser.getId();
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = getUserById(id);
        user.setName(userDto.getName());
        User updatedUser = userRepository.save(user);
        log.info("Выполнено обновление в БД пользователя: {}", updatedUser);
        UserDto updatedUserDto = userMapper.toUserDto(updatedUser);
        log.debug("Выполнен маппинг  в DTO: {}", updatedUserDto);
        return updatedUserDto;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        log.info("Выполнено удаление из БД пользователя с id: {}", id);
    }

    @Override
    public Long addSubscriptionToUser(Long userId, SubscriptionDto subscriptionDto) {
        User user = getUserById(userId);
        Subscription subscription = subscriptionService.findOrCreateSubscription(subscriptionDto);
        boolean added = user.getSubscriptions().add(subscription);
        if (added) {
            userRepository.save(user);
            log.info("Выполнено добавление в БД к пользователю: {} подписки: {}", user, subscription);
        } else {
            log.debug("У пользователя: {} уже имеется подписка: {}", user, subscription);
        }
        return subscription.getId();
    }

    @Override
    public void deleteSubscriptionFromUserById(Long id, Long subId) {
        User user = getUserById(id);
        Subscription subscription = subscriptionService.getSubscriptionById(subId);
        boolean removed = user.getSubscriptions().remove(subscription);
        if (!removed) {
            throw new SubscriptionNotBelongToUser(String.format("У пользователя с id: %s не найдена подписка с id: %s", id, subId));
        }
        userRepository.save(user);
        log.info("Выполнено удаление в БД у пользователя: {} подписки: {}", user, subscription);
    }
}
