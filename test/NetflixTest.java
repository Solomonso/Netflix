import com.solomon.episode.Episode;
import com.solomon.episode.EpisodeQuality;
import com.solomon.episode.SponsoredEpisode;
import com.solomon.netflix.Netflix;
import com.solomon.season.Season;
import com.solomon.serie.Serie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NetflixTest {
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
    void durationOfTvShow() {
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
        got.addSeasons(seasonOne);
        got.addSeasons(seasonTwo);

        netflix.addSeries(got);
        assertEquals("complete running time of got is 4:00:00",netflix.durationOfTvShow(got));
    }

    @Test
    void mostInterestingEpisodeInASerie() {
        HashSet<Episode> mostInteresting = new HashSet<>();

        episodeOne = new Episode("good", Duration.ofMinutes(60),EpisodeQuality.HD);
        episodeThree = new Episode("Action", Duration.ofMinutes(30), EpisodeQuality.SD);

        episodeOne.setRating(5);
        episodeThree.setRating(5);

        seasonOne.addEpisode(episodeOne);
        seasonOne.addEpisode(episodeThree);

        supernatural.addSeasons(seasonOne);

        netflix.addSeries(supernatural);

        //add episode to most interesting
        mostInteresting.add(episodeOne);
        mostInteresting.add(episodeThree);

        assertEquals(mostInteresting,netflix.mostInterestingEpisodesInASerie(supernatural));
    }

    @Test
    void mostBoringEpisodeInASerie() {
        HashSet<Episode> mostBoring = new HashSet<>();

        episodeOne = new Episode("good", Duration.ofMinutes(60),EpisodeQuality.HD);
        episodeThree = new Episode("Action", Duration.ofMinutes(30), EpisodeQuality.SD);

        episodeOne.setRating(1);
        episodeThree.setRating(1);

        seasonOne.addEpisode(episodeOne);
        seasonOne.addEpisode(episodeThree);

        supernatural.addSeasons(seasonOne);

        netflix.addSeries(supernatural);

        //add episode to most interesting
        mostBoring.add(episodeOne);
        mostBoring.add(episodeThree);

        assertEquals(mostBoring,netflix.mostBoringEpisodesInASerie(supernatural));
    }
}
