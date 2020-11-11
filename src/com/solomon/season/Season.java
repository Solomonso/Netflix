package com.solomon.season;

import com.solomon.episode.Episode;

import java.time.Duration;
import java.util.HashSet;

/**
 * The Season class holds the Episode details.
 */
public class Season {

    private int number;
    //An HashSet for storing episodes
    private HashSet<Episode> episodes;

    /**
     * Creates a new Season and initialize the episode collection.
     *
     * @param number Accepts an int to represent the season number.
     */
    public Season(int number) {
        setNumber(number);
        this.episodes = new HashSet<Episode>();
    }

    /**
     * The method returns the number of a season.
     *
     * @return Returns an int.
     */
    public int getNumber() {
        return number;
    }

    /**
     * This method sets a new season number and the input cannot be less than 0
     *
     * @param number Accepts an int.
     */
    public void setNumber(int number) {
        if (number > 0) {
            this.number = number;
        }
    }

    /**
     * This method returns a HashSet collection containing episodes.
     *
     * @return Return episodes.
     */
    public HashSet<Episode> getEpisodes() {
        return this.episodes;
    }

    /**
     * This method adds an episode to the collection.
     *
     * @param episode Accepts an Episode.
     */
    public void addEpisode(Episode episode) {
        this.episodes.add(episode);
    }

    /**
     * This method returns the complete duration of all episodes in season
     * @return Returns the duration of the season
     */
    public Duration durationOfSeason() {
        Duration seasonDuration = Duration.ofMillis(0L);
        for(Episode episode : this.episodes) {
            seasonDuration = seasonDuration.plusMillis(episode.getEpisodeTime().toMillis());
        }
        return seasonDuration;
    }
    /**
     * This method returns the details in a readable format.
     *
     * @return Returns the season number with their episodes.
     */
    @Override
    public String toString() {
        return "Season{" +
                "number=" + number +
                ", episodes=" + episodes +
                '}';
    }
}
