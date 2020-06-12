package tk.khabibullin.grabber.service.codeforces;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tk.khabibullin.grabber.connector.codeforces.CodeforcesConnector;
import tk.khabibullin.grabber.connector.telegram.TelegramConnector;
import tk.khabibullin.grabber.dto.codeforces.CodeforcesContest;
import tk.khabibullin.grabber.dto.telegram.TelegramMessageDto;
import tk.khabibullin.grabber.dto.telegram.TelegramSendMessageRequestDto;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CodeforcesContestsTelegramNotificationServiceImpl implements CodeforcesContestsTelegramNotificationService {
    private final CodeforcesConnector codeforcesConnector;
    private final TelegramConnector telegramConnector;

    @Override
    public TelegramMessageDto sendAllFutureContestsNotification(String chatId) {
        List<CodeforcesContest> futureContests = codeforcesConnector.getContests().getResult().stream()
                .filter(codeforcesContest -> codeforcesContest.getStartTime().isAfter(Instant.now()))
                .sorted()
                .collect(Collectors.toList());
        System.err.printf("Found %d future contests.\n", futureContests.size());
        String messageText = futureContests.stream()
                .map(this::convertCodeforcesContestToTelegramMessage)
                .collect(Collectors.joining("\n"));
        TelegramSendMessageRequestDto messageRequest = new TelegramSendMessageRequestDto(chatId, messageText);
        return telegramConnector.sendMessage(messageRequest);
    }

    private String convertCodeforcesContestToTelegramMessage(CodeforcesContest contest) {
        return String.format(
                "%s\n%s\n%s",
                contest.getName(),
                DateTimeFormatter.RFC_1123_DATE_TIME.format(contest.getStartTime()),
                contest.getDuration()
        );
    }
}
