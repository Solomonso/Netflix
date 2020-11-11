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
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeasonTest {

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
        //setup episode
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
    void durationOfSeason() {
         episodeOne = new Episode("die", Duration.ofMinutes(60),EpisodeQuality.HD);
         episodeThree = new Episode("ghost", Duration.ofMinutes(30), EpisodeQuality.SD);
         seasonOne = new Season(1);
         seasonOne.addEpisode(episodeOne);
         seasonOne.addEpisode(episodeThree);

        assertEquals("1:30:00", DurationHelper.formatDuration(seasonOne.durationOfSeason()));
    }

    @Test
    void getEpisodes() {
        HashSet<Episode> episodes = new HashSet<>();
        episodeOne = new Episode("die", Duration.ofMinutes(60),EpisodeQuality.HD);
        episodeThree = new Episode("ghost", Duration.ofMinutes(30), EpisodeQuality.SD);
        Season season = new Season(1);

        season.addEpisode(episodeOne);
        season.addEpisode(episodeThree);
        episodes.add(episodeOne);
        episodes.add(episodeThree);

        assertEquals(episodes, season.getEpisodes());

    }
}
