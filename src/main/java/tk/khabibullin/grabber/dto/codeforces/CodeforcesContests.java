package tk.khabibullin.grabber.dto.codeforces;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public class CodeforcesContests {
    List<CodeforcesContest> result;
    String status;

    @JsonCreator
    public CodeforcesContests(
            @JsonProperty("result") List<CodeforcesContest> result,
            @JsonProperty("status") String status
    ) {
        this.result = result;
        this.status = status;
    }
}
