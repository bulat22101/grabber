package tk.khabibullin.grabber.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tk.khabibullin.grabber.connector.telegram.HttpTelegramConnector;
import tk.khabibullin.grabber.connector.telegram.TelegramConnector;

@Component
public class MainConfig {
    @Bean
    public RestTemplate getRestClient() {
        return new RestTemplate();
    }

    @Bean
    public TelegramConnector getTelegramConnector(
            RestTemplate restTemplate,
            @Value("${telegramToken}") String telegramToken,
            @Value("${chatId}") String chatId
    ) {
        return new HttpTelegramConnector(restTemplate, telegramToken, chatId);
    }
}
