package tk.khabibullin.grabber.service.codeforces;

import org.springframework.stereotype.Service;
import tk.khabibullin.grabber.dto.telegram.TelegramMessageDto;

@Service
public interface CodeforcesContestsTelegramNotificationService {
    TelegramMessageDto sendAllFutureContestsNotification(String chatId);
}
