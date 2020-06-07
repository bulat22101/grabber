package tk.khabibullin.grabber.connector.telegram;

import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;
import tk.khabibullin.grabber.dto.telegram.TelegramMessageDto;
import tk.khabibullin.grabber.dto.telegram.TelegramSendMessageRequestDto;

@RequiredArgsConstructor
public class HttpTelegramConnector implements TelegramConnector {
    final static String BASE_URL = "https://api.telegram.org/bot";
    final RestTemplate restTemplate;
    final String telegramToken;
    final String myTelegramChatId;

    @Override
    public TelegramMessageDto sendMessage(String text) {
        String url = BASE_URL + telegramToken + "/sendMessage";
        TelegramSendMessageRequestDto requestDto = new TelegramSendMessageRequestDto(myTelegramChatId, text);
        return restTemplate.postForEntity(url, requestDto, TelegramMessageDto.class).getBody();
    }
}