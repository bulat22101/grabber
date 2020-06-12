package tk.khabibullin.grabber.service;

import tk.khabibullin.grabber.dto.telegram.TelegramUpdateDto;

public interface TelegramUpdateResolver {
    void resolveUpdate(TelegramUpdateDto update);
}
