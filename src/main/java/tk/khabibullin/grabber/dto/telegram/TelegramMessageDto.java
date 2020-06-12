package tk.khabibullin.grabber.dto.telegram;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.time.Instant;

@Value
public class TelegramMessageDto {
    Long messageId;
    Instant time;
    TelegramChatDto chat;
    String text;

    @JsonCreator
    public TelegramMessageDto(
            @JsonProperty("message_id") Long messageId,
            @JsonProperty("date") Instant time,
            @JsonProperty("chat") TelegramChatDto chat,
            @JsonProperty("text") String text
    ) {
        this.messageId = messageId;
        this.time = time;
        this.chat = chat;
        this.text = text;
    }
}
