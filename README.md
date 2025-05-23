UserAndSubscriptionService — это REST API для управления пользователями и их подписками.
> Подписки представляют собой подписки на цифровые сервисы, такие как
YouTube Premium, VK Музыка, Яндекс.Плюс, Netflix и другие стриминговые
платформы.

Позволяет:

**API для управления пользователями**
- Создание пользователя.
- Получение информации о пользователе.
- Обновление данных пользователя.
- Удаление пользователя.
- 
 **API для подписок**
- Добавление подписки пользователю.
- Получение списка подписок пользователя.
- Удаление подписки у пользователя.
- Подписки представляют собой подписки на цифровые сервисы, такие как
  YouTube Premium, VK Музыка, Яндекс.Плюс, Netflix и другие стриминговые
  платформы.
---

## 🚀 Стек технологий

- Java 17 
- Spring Boot (Data JPA, )
- PostgreSQL / H2
- Flyway
- Lombok
- Docker, Docker Compose
- Swagger
- Mapstruct
- SLF4J

---

## ⚙️ Установка и запуск

- Склонировать репозиторий: ```git clone https://github.com/MingazOFF/userAndSubscriptionService.git```

- Перейти в директорию проекта:
```cd userAndSubscriptionService ```

- Запустить сервис: 
```docker compose up```

- Перейти по ссылке: http://localhost:8088/swagger-ui/index.html