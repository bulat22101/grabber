package tk.khabibullin.grabber.connector.codeforces;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import tk.khabibullin.grabber.dto.codeforces.CodeforcesContests;

@Component
@RequiredArgsConstructor
public class HttpCodeforcesConnector implements CodeforcesConnector {
    final RestTemplate restTemplate;

    @Override
    @SneakyThrows
    public CodeforcesContests getContests() {
        return restTemplate.getForEntity("https://codeforces.com/api/contest.list", CodeforcesContests.class).getBody();
    }
}
