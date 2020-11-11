import com.solomon.episode.Episode;
import com.solomon.episode.EpisodeQuality;
import com.solomon.episode.SponsoredEpisode;
import com.solomon.netflix.Netflix;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RateEpisodeTest {
    private Episode episodeOne;
    private SponsoredEpisode episodeTwo;

    @Test
    void rateEpisode() {
        episodeOne = new Episode("good", Duration.ofMinutes(60),EpisodeQuality.HD);
        Netflix netflix = new Netflix();

        assertEquals("good has been given a rating of 1",netflix.rateEpisode(episodeOne,1));
    }

    @Test
    void rateEpisodeOutOfScope() {
        episodeOne = new Episode("good", Duration.ofMinutes(60),EpisodeQuality.HD);
        Netflix netflix = new Netflix();

        assertEquals("good has been given a rating of 0",netflix.rateEpisode(episodeOne,-1));

    }

    @Test
    void rateSponsoredEpisode() {
        episodeTwo = new SponsoredEpisode("die hard", Duration.ofMinutes(60),EpisodeQuality.HD,"coke");
        Netflix netflix = new Netflix();

        assertEquals("die hard is sponsored by coke has been given a rating of 5. So, Netflix earn extra cash",netflix.rateEpisode(episodeTwo,3));

    }

    @Test
    void rateSponsoredEpisodeOutScope() {
        episodeTwo = new SponsoredEpisode("die hard", Duration.ofMinutes(60), EpisodeQuality.HD,"coke");
        Netflix netflix = new Netflix();

        assertEquals("die hard is sponsored by coke has been given a rating of 0. So, Netflix earn extra cash",netflix.rateEpisode(episodeTwo,5));

    }
}
