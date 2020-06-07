package tk.khabibullin.grabber.connector.telegram;

import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;
import tk.khabibullin.grabber.dto.telegram.TelegramMessageDto;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class HttpTelegramConnector implements TelegramConnector {
    final static String BASE_URL = "https://api.telegram.org/bot";
    final RestTemplate restTemplate;
    final String telegramToken;
    final String myTelegramChatId;

    @Override
    public TelegramMessageDto sendMessage(String text) {
        String url = BASE_URL + telegramToken + "/sendMessage";
        Map<String, String> params = new HashMap<>();
        params.put("chat_id", myTelegramChatId);
        params.put("text", text);
        return restTemplate.postForEntity(url, null, TelegramMessageDto.class, params).getBody();
    }
}