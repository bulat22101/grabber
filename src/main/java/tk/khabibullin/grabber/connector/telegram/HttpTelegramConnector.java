package tk.khabibullin.grabber.connector.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tk.khabibullin.grabber.dto.telegram.TelegramMessageDto;
import tk.khabibullin.grabber.dto.telegram.TelegramSendMessageRequestDto;

@Component
public class HttpTelegramConnector implements TelegramConnector {
    final static String BASE_URL = "https://api.telegram.org/bot";
    final RestTemplate restTemplate;
    final String telegramToken;

    public HttpTelegramConnector(
            RestTemplate restTemplate,
            @Value("${telegramToken}") String telegramToken
    ) {
        this.restTemplate = restTemplate;
        this.telegramToken = telegramToken;
    }

    @Override
    public TelegramMessageDto sendMessage(TelegramSendMessageRequestDto sendMessageRequest) {
        String url = BASE_URL + telegramToken + "/sendMessage";
        ResponseEntity<TelegramMessageDto> responseEntity =
                restTemplate.postForEntity(url, sendMessageRequest, TelegramMessageDto.class);
        return responseEntity.getBody();
    }
}