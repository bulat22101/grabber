package tk.khabibullin.grabber.dto.telegram;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.time.Instant;

@Value
public class TelegramMessageDto {
    Long messageId;
    Instant time;

    @JsonCreator
    public TelegramMessageDto(
            @JsonProperty("message_id") Long messageId,
            @JsonProperty("date") Instant time
    ) {
        this.messageId = messageId;
        this.time = time;
    }
}
