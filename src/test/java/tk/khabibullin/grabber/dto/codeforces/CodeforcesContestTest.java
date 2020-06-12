package tk.khabibullin.grabber.dto.codeforces;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import tk.khabibullin.grabber.connector.codeforces.HttpCodeforcesConnector;

import static org.junit.jupiter.api.Assertions.*;

class CodeforcesContestTest {

    @Test
    void  test() {
        System.err.println(
                (new HttpCodeforcesConnector(new RestTemplate())).getContests()
        );
    }

}