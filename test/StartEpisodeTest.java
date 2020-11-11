import com.solomon.episode.Episode;
import com.solomon.episode.EpisodeQuality;
import com.solomon.netflix.Netflix;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartEpisodeTest {
    private Episode episodeOne;

    @Test
    void startEpisode() {
        episodeOne = new Episode("good", Duration.ofMinutes(60), EpisodeQuality.HD);
        Netflix netflix = new Netflix();

        assertEquals("episode good started duration 1:00:00",netflix.startEpisode(episodeOne));

    }
}
