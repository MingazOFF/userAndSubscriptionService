package ru.mingazoff.userAndSubscriptionService.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mingazoff.userAndSubscriptionService.model.entity.Subscription;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
}
