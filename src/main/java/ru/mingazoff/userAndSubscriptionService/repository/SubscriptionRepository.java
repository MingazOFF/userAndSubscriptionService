package ru.mingazoff.userAndSubscriptionService.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mingazoff.userAndSubscriptionService.model.entity.Subscription;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {

    @Query(value = """
                SELECT s.* FROM subscriptions s
                INNER JOIN user_subscriptions us ON s.id = us.subscription_id
                GROUP BY s.id
                ORDER BY COUNT(us.subscription_id) DESC
                LIMIT 3
            """, nativeQuery = true)
    List<Subscription> findTop3Subscriptions();

    Optional<Subscription> findByName(String name);

}
