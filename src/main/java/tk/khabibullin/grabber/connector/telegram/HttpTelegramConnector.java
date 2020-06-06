package tk.khabibullin.grabber.connector.telegram;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tk.khabibullin.grabber.dto.telegram.TelegramMessage;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class HttpTelegramConnector implements TelegramConnector {
    final static String BASE_URL = "https://api.telegram.org/bot";
    final RestTemplate restTemplate;
    final String telegramToken;
    final String myTelegramChatId;

    @Override
    public TelegramMessage sendMessage(String text) {
        Map<String, String> data = new HashMap<>();
        data.put("chatId", myTelegramChatId);
        data.put("text", text);
        String url = BASE_URL + telegramToken + "/sendMessage";
        System.err.println(url);
        System.err.println(myTelegramChatId);
        System.err.println(text);
        return restTemplate.getForEntity(url, TelegramMessage.class, data).getBody();
    }
}
