package tk.khabibullin.grabber.connector.telegram;

import tk.khabibullin.grabber.dto.telegram.TelegramMessageDto;

public interface TelegramConnector {
    TelegramMessageDto sendMessage(String text);
}
