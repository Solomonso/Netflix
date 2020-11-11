package com.solomon.serie;

import com.solomon.season.Season;

import java.time.Duration;
import java.util.HashSet;

/**
 * The Serie class holds the Season information and it contains an episode in it
 */
public class Serie {
    private String name;
    //An HashSet to store com.solomon.season
    private HashSet<Season> seasons;

    /**
     * Creates a new Serie and initialize the HashSet.
     *
     * @param name Accepts a String to represent the serie name.
     */
    public Serie(String name) {
        this.name = name;
        this.seasons = new HashSet<Season>();
    }

    /**
     * This methods returns the serie name.
     *
     * @return Returns a String that represent the name of the serie.
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method set a new name for the serie.
     *
     * @param name Accepts String for the serie name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This methods return a collection containing season.
     *
     * @return Return a seasons.
     */
    public HashSet<Season> getSeasons() {
        return this.seasons;
    }

    /**
     * This method adds the season to the collection.
     *
     * @param season Accepts Season.
     */
    public void addSeasons(Season season) {
        this.seasons.add(season);
    }

    /**
     * This method returns the complete duration of all the com.solomon.season found in serie.
     *
     * @return Return duration of serie.
     */
    public Duration durationOfSerie() {
        Duration serieDuration = Duration.ofMillis(0L);
        for (Season s : this.seasons) {
            serieDuration = serieDuration.plus(s.durationOfSeason());
        }
        return serieDuration;
    }

    /**
     * This method returns the details in a readable format
     *
     * @return Returns the serie name and the season number
     */
    @Override
    public String toString() {
        return "Serie{" +
                "name='" + name + '\'' +
                ", seasons=" + seasons +
                '}';
    }
}
