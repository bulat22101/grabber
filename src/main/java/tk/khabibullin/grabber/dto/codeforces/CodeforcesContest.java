package tk.khabibullin.grabber.dto.codeforces;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.time.Instant;

@Value
public class CodeforcesContest {
    Long id;
    String name;
    Instant startTime;
    Long durationSeconds;
    Long relativeTimeSeconds;

    @JsonCreator
    CodeforcesContest(
            @JsonProperty("id") Long id,
            @JsonProperty("name") String name,
            @JsonProperty("startTimeSeconds") Long startTimeSeconds,
            @JsonProperty("DurationSeconds") Long durationSeconds,
            @JsonProperty("relativeTimeSeconds") Long relativeTimeSeconds
    ) {
        this.id = id;
        this.name = name;
        this.startTime = Instant.ofEpochSecond(startTimeSeconds);
        this.durationSeconds = durationSeconds;
        this.relativeTimeSeconds = relativeTimeSeconds;
    }
}
