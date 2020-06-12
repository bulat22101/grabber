package tk.khabibullin.grabber.dto.telegram;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class TelegramUpdateDto {
    TelegramMessageDto message;

    @JsonCreator
    public TelegramUpdateDto(@JsonProperty("message") TelegramMessageDto message) {
        this.message = message;
    }
}
