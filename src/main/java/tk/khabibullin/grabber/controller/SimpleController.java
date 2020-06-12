package tk.khabibullin.grabber.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.khabibullin.grabber.service.codeforces.CodeforcesContestsTelegramNotificationService;

@RestController
@RequiredArgsConstructor
public class SimpleController {
    final CodeforcesContestsTelegramNotificationService telegramNotificationService;

    @GetMapping("/")
    public String main() {
        return "OK!";
    }
}
