import com.solomon.episode.Episode;
import com.solomon.episode.EpisodeQuality;
import com.solomon.episode.SponsoredEpisode;
import com.solomon.helperClass.DurationHelper;
import com.solomon.netflix.Netflix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.solomon.season.Season;
import com.solomon.serie.Serie;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SerieTest {

    private Episode episodeOne;
    private SponsoredEpisode episodeTwo;
    private Episode episodeThree;
    private SponsoredEpisode episodeFour;

    private Season seasonOne;
    private Season seasonTwo;

    private Serie supernatural;
    private Serie got;

    private Netflix netflix;

    @BeforeEach
    void setup()
    {
        //setup seasons
        seasonOne = new Season(1);
        seasonTwo = new Season(2);

        //setup series
        supernatural = new Serie("supernatural");
        got = new Serie("got");

        //setup Netflix
        netflix = new Netflix();
    }

    @Test
    void getSeasons() {
    }

    @Test
    void durationOfSerie() {
        episodeOne = new Episode("good", Duration.ofMinutes(60),EpisodeQuality.HD);
        episodeTwo = new SponsoredEpisode("die hard", Duration.ofMinutes(30), EpisodeQuality.SD,"coke");
        episodeThree = new Episode("Action", Duration.ofMinutes(30), EpisodeQuality.SD);
        episodeFour = new SponsoredEpisode("ghost", Duration.ofMinutes(120), EpisodeQuality._4K, "bet9ja");

        seasonOne = new Season(1);
        seasonTwo = new Season(2);

        //add episode to season 1
        seasonOne.addEpisode(episodeOne);
        seasonOne.addEpisode(episodeTwo);

        //add episode to season two
        seasonTwo.addEpisode(episodeThree);
        seasonTwo.addEpisode(episodeFour);

        //add the seasons to supernatural
        supernatural.addSeasons(seasonOne);
        supernatural.addSeasons(seasonTwo);

        assertEquals("4:00:00", DurationHelper.formatDuration(supernatural.durationOfSerie()));

    }
}
