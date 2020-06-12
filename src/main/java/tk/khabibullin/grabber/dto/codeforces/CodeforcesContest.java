package tk.khabibullin.grabber.dto.codeforces;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Value
public class CodeforcesContest {
    Long id;
    String name;
    Instant startTime;
    Duration duration;
    Long relativeTimeSeconds;

    @JsonCreator
    public CodeforcesContest(
            @JsonProperty("id") Long id,
            @JsonProperty("name") String name,
            @JsonProperty("startTimeSeconds") Long startTimeSeconds,
            @JsonProperty("durationSeconds") Long durationSeconds,
            @JsonProperty("relativeTimeSeconds") Long relativeTimeSeconds
    ) {
        this.id = id;
        this.name = name;
        this.startTime = Instant.ofEpochSecond(startTimeSeconds);
        this.duration = Duration.of(durationSeconds, ChronoUnit.SECONDS);
        this.relativeTimeSeconds = relativeTimeSeconds;
    }
}
