package ru.mingazoff.userAndSubscriptionService.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mingazoff.userAndSubscriptionService.model.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
