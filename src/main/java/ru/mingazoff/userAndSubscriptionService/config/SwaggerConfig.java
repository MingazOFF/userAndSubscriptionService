package ru.mingazoff.userAndSubscriptionService.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "User and Subscription API",
                description = "Микросервис на Spring Boot 3, который предоставляет REST API " +
                        "для управления пользователями и их подписками на сервисы.",
                contact = @Contact(
                        name = "Renat Mingazov",
                        email = "mingazofff@gmail.com",
                        url = "https://github.com/MingazOFF/userAndSubscriptionService.git"
                ),
                license = @License(
                        name = "No license required"
                ),
                version = "0.0.1-SNAPSHOT"
        ),
        servers = @Server(
                url = "http://localhost:8088",
                description = "User and Subscription API"
        )
)
public class SwaggerConfig {
}
