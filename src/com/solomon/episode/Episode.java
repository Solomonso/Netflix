package com.solomon.episode;

import com.solomon.helperClass.DurationHelper;

import java.time.Duration;

/**
 * The Episode class is a parent class of SponsoredEpisode.
 * The Episode class Represent the episode information.
 * The default rating is 0
 */

public class Episode {
    protected String episodeName;
    protected Duration episodeTime;
    protected int rating;
    protected EpisodeQuality episodeQuality;

    /**
     * Creates a new episode with episodeName and episodeTime.
     *
     * @param episodeName Accepts String for the episodeName.
     * @param episodeTime Accepts Duration for the episodeTime.
     * @param episodeQuality Accepts EpisodeQuality
     */
    public Episode(String episodeName, Duration episodeTime, EpisodeQuality episodeQuality) {
        this.episodeName = episodeName;
        this.episodeTime = episodeTime;
        this.episodeQuality = episodeQuality;
        this.rating = 0;
    }

    /**
     * This method returns the episode name.
     *
     * @return Returns a String that represent the name of episode.
     */
    public String getEpisodeName() {
        return this.episodeName;
    }

    /**
     * This method set the episode name.
     *
     * @param episodeName The episodeName is String.
     */
    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    /**
     * This method returns the episode duration.
     *
     * @return Return Duration of episode.
     */
    public Duration getEpisodeTime() {
        return this.episodeTime;
    }

    /**
     * This method set the duration of the episode.
     *
     * @param episodeTime Set duration of episode.
     */
    public void setEpisodeTime(Duration episodeTime) {
        this.episodeTime = episodeTime;
    }

    /**
     * This method returns the rating of the episode.
     *
     * @return Returns the rating of a episode.
     */
    public int getRating() {
        return this.rating;
    }

    /**
     * The method sets the rating of the episode.
     *
     * @param rating Accept an int for the rating between 1 to 5
     */
    public void setRating(int rating) {
        if ((rating > 0 && rating <= 5))
            this.rating = rating;
    }

    /**
     *
     * @return Return the quality of episode
     */
    public String getQuality() {
        String message = "";
        switch (this.episodeQuality) {
            case SD:
                message = "you are playing an SD video";
                break;
            case HD:
                message = "you are playing an HD video";
                break;
            case _4K:
                message = "you are playing a 4K video";
                break;
            default:
                message = "No video quality found";
        }
        return message;
    }

    /**
     * The method returns the episode details in a readable format
     *
     * @return Returns all the properties of the Episode class
     */
    @Override
    public String toString() {
        return "Episode{" +
                "episodeName='" + this.episodeName + '\'' +
                ", episodeTime=" + DurationHelper.formatDuration(this.episodeTime) +
                ", rating=" + this.rating +
                '}';
    }
}
