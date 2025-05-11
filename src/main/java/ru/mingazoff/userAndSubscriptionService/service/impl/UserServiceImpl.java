package ru.mingazoff.userAndSubscriptionService.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserWithSubscriptionsMapper userWithSubscriptionsMapper;
    private final SubscriptionService subscriptionService;

    @Override
    public UserDto getUserDtoById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return userMapper.toUserDto(user);
    }

    @Override
    public UserWithSubscriptionsDto getUserWithSubscriptionsDtoById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return userWithSubscriptionsMapper.toUserWithSubscriptionsDto(user);
    }

    @Override
    public Long createUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    @Override
    public void updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElse(null);
        user.setName(userDto.getName());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Long addSubscriptionToUser(Long userId, SubscriptionDto subscriptionDto) {
        User user = userRepository.findById(userId).orElse(null);
        Subscription subscription = subscriptionService.findOrCreateSubscription(subscriptionDto);
        user.getSubscriptions().add(subscription);
        userRepository.save(user);
        return subscription.getId();
    }

    @Override
    public void deleteSubscriptionFromUserById(Long id, Long subId) {
        User user = userRepository.findById(id).orElse(null);
        Subscription subscription = subscriptionService.getSubscriptionById(subId);
        user.getSubscriptions().remove(subscription);
        userRepository.save(user);
    }
}
