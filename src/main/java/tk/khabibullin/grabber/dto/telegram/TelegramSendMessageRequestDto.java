package tk.khabibullin.grabber.dto.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class TelegramSendMessageRequestDto {
    @JsonProperty("chat_id")
    String chatId;
    String text;
}
