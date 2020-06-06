package tk.khabibullin.grabber.connector.telegram;

import tk.khabibullin.grabber.dto.telegram.TelegramMessage;

public interface TelegramConnector {
    TelegramMessage sendMessage(String text);
}
