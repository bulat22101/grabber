package tk.khabibullin.grabber.connector.telegram;

import tk.khabibullin.grabber.dto.telegram.TelegramMessageDto;
import tk.khabibullin.grabber.dto.telegram.TelegramSendMessageRequestDto;

public interface TelegramConnector {
    TelegramMessageDto sendMessage(TelegramSendMessageRequestDto sendMessageRequest);
}
