package ru.mingazoff.userAndSubscriptionService.mapper;

import org.mapstruct.Mapper;
import ru.mingazoff.userAndSubscriptionService.model.dto.UserDto;
import ru.mingazoff.userAndSubscriptionService.model.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);

    User toUser(UserDto userDto);
}
