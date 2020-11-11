import com.solomon.episode.Episode;
import com.solomon.episode.EpisodeQuality;
import com.solomon.episode.SponsoredEpisode;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EpisodeTest {

    private Episode episodeOne;
    private SponsoredEpisode episodeTwo;
    private Episode episodeThree;
    private SponsoredEpisode episodeFour;

    @Test
    void getQuality() {
        episodeOne = new Episode("good", Duration.ofMinutes(60),EpisodeQuality.HD);
        episodeTwo = new SponsoredEpisode("die hard", Duration.ofMinutes(30),EpisodeQuality.SD,"coke");
        episodeThree = new Episode("Action", Duration.ofMinutes(30), EpisodeQuality._4K);

        assertEquals("you are playing an HD video", episodeOne.getQuality());
        assertEquals("you are playing an SD video", episodeTwo.getQuality());
        assertEquals("you are playing a 4K video", episodeThree.getQuality());
    }
}
