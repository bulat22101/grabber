package tk.khabibullin.grabber.controller.webhook;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tk.khabibullin.grabber.dto.telegram.TelegramUpdateDto;
import tk.khabibullin.grabber.service.TelegramUpdateResolver;

@RestController
@RequiredArgsConstructor
public class TelegramWebhookController {
    TelegramUpdateResolver telegramUpdateResolver;

    @PostMapping("/webhook")
    public ResponseEntity<String> postUpdate(@RequestBody TelegramUpdateDto update) {
        telegramUpdateResolver.resolveUpdate(update);
        return ResponseEntity.ok("OK");
    }
}
