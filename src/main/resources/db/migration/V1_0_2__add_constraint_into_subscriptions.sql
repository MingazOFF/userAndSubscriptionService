-- name: alter table subscriptions: add constraint
-- author: Renat Mingazov
-- date: 2025.05.10

ALTER TABLE subscriptions
    ADD CONSTRAINT uc_subscription_name UNIQUE (subscription_name);