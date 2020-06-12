package tk.khabibullin.grabber.dto.telegram;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class TelegramChatDto {
    String id;

    @JsonCreator
    public TelegramChatDto(@JsonProperty("id") String chatId) {
        this.id = chatId;
    }
}
