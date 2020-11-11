package com.solomon.netflix;

import com.solomon.serie.*;
import com.solomon.episode.*;
import com.solomon.helperClass.*;
import com.solomon.season.*;

import java.util.HashSet;

/**
 * The class Netflix is the major class of the program, it contains the serie.
 * The Netflix class can start an episode.
 * Rate An Episode.
 * Gets the most interesting and boring episodes per serie.
 * It shows the complete duration of a serie and the season.
 */
public class Netflix {
    //An Hashset to store the series
    private HashSet<Serie> series;

    /**
     * Creates a Netflix and initialize the serie collection
     */
    public Netflix() {
        this.series = new HashSet<Serie>();
    }

    /**
     * This method returns a collection of serie.
     *
     * @return Returns a series with serie name, season number and their episodes.
     */
    public HashSet<Serie> getSeries() {
        return this.series;
    }

    /**
     * This method add serie to the collection.
     *
     * @param serie Accepts Serie.
     */
    public void addSeries(Serie serie) {
        this.series.add(serie);
    }

    /**
     * This method Starts an Episode.
     * if not it shows Not Found.
     *
     * @param episode Accepts an episode.
     * @return Returns a String with episode name and the duration.
     */
    public String startEpisode(Episode episode) {
        return "episode " + episode.getEpisodeName() + " started " + "duration " + DurationHelper.formatDuration(episode.getEpisodeTime());
    }

    /**
     * The method rates an episode from 1 to 5.
     *
     * @param episode Accepts an com.solomon.episode.
     * @param rating  Accepts a rating, the rating is a number from 1 to 5.
     * @return Returns a String with the episode name and rating.
     */
    public String rateEpisode(Episode episode, int rating) {
        if(episode instanceof SponsoredEpisode) {
            episode.setRating(rating);
            return episode.getEpisodeName() + " is sponsored by " + ((SponsoredEpisode) episode).getSponsor() + " has been given a rating of " + episode.getRating()
                    +  ". So, Netflix earn extra cash";
        }
        else {
            episode.setRating(rating);
            return episode.getEpisodeName() + " has been given a rating of " + episode.getRating();
        }
    }

    /**
     * This method get the most interesting episode per Serie (if the episode rated 5). HashSet is used so multiple episodes can be returned.
     *
     * @param serie Accepts a serie.
     * @return Returns an Episode.
     */
    public HashSet<Episode> mostInterestingEpisodesInASerie(Serie serie) {
       HashSet<Episode> mostInteresting = new HashSet<>();
        for (Season season : serie.getSeasons()) {
            for (Episode episode : season.getEpisodes()) {
                if (episode.getRating() == 5) {
                    mostInteresting.add(episode);
                }
            }
        }
        return mostInteresting;
    }

    /**
     * This method returns the most boring episodes per Serie. (if the episode gets rated 1). HashSet is used so multiple episodes can be returned.
     *
     * @param serie Accepts a serie.
     * @return Returns an Episode.
     */
    public HashSet<Episode> mostBoringEpisodesInASerie(Serie serie) {
        HashSet<Episode> mostBoringEpisodes = new HashSet<>();
            for (Season season : serie.getSeasons()) {
                for (Episode episode : season.getEpisodes()) {
                        if (episode.getRating() == 1) {
                            mostBoringEpisodes.add(episode);
                    }
                }
            }
         return mostBoringEpisodes;
    }

    /**
     * The method returns the complete duration of serie.
     *
     * @param serieName Accepts a serie.
     * @return Returns a String showing the complete duration of a serie with their season.
     */
    public String durationOfTvShow(Serie serieName) {
       return "complete running time of " + serieName.getName() + " is " + DurationHelper.formatDuration(serieName.durationOfSerie());
    }
}
