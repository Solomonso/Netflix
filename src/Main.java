import com.solomon.episode.Episode;
import com.solomon.episode.EpisodeQuality;
import com.solomon.episode.SponsoredEpisode;
import com.solomon.netflix.Netflix;
import com.solomon.season.Season;
import com.solomon.serie.Serie;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
    Episode episode = new Episode("die hard",Duration.ofMinutes(60), EpisodeQuality._4K);

    SponsoredEpisode sponsoredEpisode = new SponsoredEpisode("ready",Duration.ofMinutes(1204), EpisodeQuality.HD, "coke");
    SponsoredEpisode sponsoredEpisode2 = new SponsoredEpisode("code",Duration.ofMinutes(60), EpisodeQuality._4K, "Fanta");

    Episode episode1 = new Episode("action", Duration.ofMinutes(30) , EpisodeQuality.SD);
    Episode episode2 = new Episode("Damn",Duration.ofMinutes(60), EpisodeQuality.HD);

    Season season = new Season(1);
    Season season1 = new Season(2);
    Season season2 = new Season(3);

    Serie serie = new Serie("got");
    Serie serie1 = new Serie("supernatural");
    Netflix netflix = new Netflix();

    }
}
