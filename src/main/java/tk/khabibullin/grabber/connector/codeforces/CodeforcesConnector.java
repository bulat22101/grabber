package tk.khabibullin.grabber.connector.codeforces;

import org.springframework.stereotype.Component;
import tk.khabibullin.grabber.dto.codeforces.CodeforcesContests;

@Component
public interface CodeforcesConnector {
    CodeforcesContests getContests();
}
