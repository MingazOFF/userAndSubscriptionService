package ru.mingazoff.userAndSubscriptionService.service;

import ru.mingazoff.userAndSubscriptionService.model.dto.UserDto;
import ru.mingazoff.userAndSubscriptionService.model.dto.UserWithSubscriptionsDto;

public interface UserService {

    UserDto getUserDtoById(Long id);

    UserWithSubscriptionsDto getUserWithSubscriptionsDtoById(Long id);

    Long createUser(UserDto userDto);
}
