package ru.mingazoff.userAndSubscriptionService.mapper;

import org.mapstruct.Mapper;
import ru.mingazoff.userAndSubscriptionService.model.dto.UserWithSubscriptionsDto;
import ru.mingazoff.userAndSubscriptionService.model.entity.User;

@Mapper(componentModel = "spring", uses = {SubscriptionMapper.class})
public interface UserWithSubscriptionsMapper {
    UserWithSubscriptionsDto toUserWithSubscriptionsDto(User user);
}
