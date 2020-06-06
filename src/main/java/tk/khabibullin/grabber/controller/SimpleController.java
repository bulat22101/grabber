package tk.khabibullin.grabber.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.khabibullin.grabber.connector.codeforces.CodeforcesConnector;
import tk.khabibullin.grabber.connector.telegram.TelegramConnector;
import tk.khabibullin.grabber.dto.codeforces.CodeforcesContest;

import java.time.Instant;
import java.util.Comparator;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SimpleController {
    final CodeforcesConnector codeforcesConnector;
    final TelegramConnector telegramConnector;

    @GetMapping("/")
    public String getClosestCodeforcesContest() {
        String message = codeforcesConnector.getContests().getResult().stream()
                .filter(contest -> contest.getStartTime().isAfter(Instant.now()))
                .sorted(Comparator.comparing(CodeforcesContest::getStartTime))
                .map(codeforcesContest -> {
                    return codeforcesContest.getName() + "\n"
                            + codeforcesContest.getStartTime().toString() + "\n"
                            + codeforcesContest.getDurationSeconds();
                })
                .collect(Collectors.joining("\n"));
        telegramConnector.sendMessage(message);
        return "OK!";
    }
}
