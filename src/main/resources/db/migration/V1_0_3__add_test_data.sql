-- name: add test data in tables: users, subscriptions and user_subscriptions
-- author: Renat Mingazov
-- date: 2025.05.10

INSERT INTO users (user_name, created_at) VALUES
    ('Михаил Петров', CURRENT_TIMESTAMP),
    ('Елена Смирнова', CURRENT_TIMESTAMP),
    ('Александр Иванов', CURRENT_TIMESTAMP),
    ('Анна Кузнецова', CURRENT_TIMESTAMP),
    ('Алексей Сидоров', CURRENT_TIMESTAMP),
    ('Татьяна Васильева', CURRENT_TIMESTAMP),
    ('Олег Соколов', CURRENT_TIMESTAMP),
    ('Екатерина Лебедева', CURRENT_TIMESTAMP),
    ('Максим Морозов', CURRENT_TIMESTAMP),
    ('Марина Попова', CURRENT_TIMESTAMP),
    ('Игорь Фёдоров', CURRENT_TIMESTAMP),
    ('Юлия Борисова', CURRENT_TIMESTAMP),
    ('Денис Яковлев', CURRENT_TIMESTAMP),
    ('Наталья Сергеева', CURRENT_TIMESTAMP),
    ('Роман Андреев', CURRENT_TIMESTAMP),
    ('Ольга Алексеева', CURRENT_TIMESTAMP),
    ('Павел Романов', CURRENT_TIMESTAMP),
    ('Дарья Шилова', CURRENT_TIMESTAMP),
    ('Константин Голубев', CURRENT_TIMESTAMP),
    ('Вероника Комарова', CURRENT_TIMESTAMP)
    ;

 INSERT INTO subscriptions (subscription_name) VALUES
    ('YouTube Premium'),
    ('VK музыка'),
    ('Яндекс.Плюс'),
    ('Netflix'),
    ('ivi'),
    ('Start'),
    ('Okko'),
    ('KION'),
    ('Premier'),
    ('Wink'),
    ('Амедитатека')
    ;

DO $$
    DECLARE
        i integer := 1;
        j integer;
    BEGIN
        WHILE i <= 20 LOOP
            j := TRUNC(RANDOM() * 10 + 1);
            IF MOD(i, 2) = 0 THEN
                INSERT INTO user_subscriptions (user_id, subscription_id) VALUES
                    (i, j),
                    (i, (j + 3) % 10 + 1)
                    ;
            ELSE
                INSERT INTO user_subscriptions (user_id, subscription_id) VALUES
                    (i, (j + 1) % 10 + 1),
                    (i, (j + 5) % 10 + 1),
                    (i, (j + 9) % 10 + 1)
                    ;
            END IF;
            i := i + 1;
        END LOOP;
END $$
