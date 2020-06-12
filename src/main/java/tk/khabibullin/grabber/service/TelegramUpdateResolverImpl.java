package tk.khabibullin.grabber.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tk.khabibullin.grabber.dto.telegram.TelegramChatDto;
import tk.khabibullin.grabber.dto.telegram.TelegramMessageDto;
import tk.khabibullin.grabber.dto.telegram.TelegramUpdateDto;
import tk.khabibullin.grabber.service.codeforces.CodeforcesContestsTelegramNotificationService;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TelegramUpdateResolverImpl implements TelegramUpdateResolver {
    final CodeforcesContestsTelegramNotificationService codeforcesContestsTelegramNotificationService;

    @Override
    public void resolveUpdate(TelegramUpdateDto update) {
        Optional.ofNullable(update)
                .map(TelegramUpdateDto::getMessage)
                .filter(message -> message.getText().contains("/get_future_contests"))
                .map(TelegramMessageDto::getChat)
                .map(TelegramChatDto::getId)
                .ifPresent(codeforcesContestsTelegramNotificationService::sendAllFutureContestsNotification);
    }
}
