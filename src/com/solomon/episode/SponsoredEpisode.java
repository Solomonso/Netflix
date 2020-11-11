package com.solomon.episode;

import java.time.Duration;

/**
 * The SponsoredEpisode is a child class of Episode.
 * Contains all the properties of Episode.
 * It holds sponsor name. And a rating of each sponsored episode is incremented by one.
 */
public class SponsoredEpisode extends Episode {
    private String sponsor;
    private int incrementRating;

    /**
     * Creates a new SponsoredEpisode
     *
     * @param episodeName Accepts a String for the episodeName.
     * @param episodeTime Accepts a Duration for the duration of the episodeTime.
     * @param sponsor     Accepts a String for the sponsor.
     */
    public SponsoredEpisode(String episodeName, Duration episodeTime, EpisodeQuality episodeQuality, String sponsor) {
        super(episodeName, episodeTime, episodeQuality);
        this.sponsor = sponsor;
        this.incrementRating = 0;
    }

    /**
     * This method returns the sponsor of the episode.
     *
     * @return Returns a String that represent the sponsor name.
     */
    public String getSponsor() {
        return sponsor;
    }

    /**
     * This method sets a new sponsor.
     *
     * @param sponsor Accepts a String to set new sponsor name.
     */
    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    /**
     * This methods sets the rating for the sponsored episode and each rating is incremented by 1. So a rating of 0 is 1 but cannot exceed 5.
     *
     * @param rating Accept an int for the rating between 0 to 5
     */
    @Override
    public void setRating(int rating) {
        if ((rating > 0 && rating < 5)) {
            super.setRating(this.incrementRating = rating);
            this.incrementRating+=2;
        }
    }

    /**
     * This method returns the rating of the Sponsored episode And its been overridden from the getRating in the parent class.
     *
     * @return Returns the sponsored Episode rating.
     */
    @Override
    public int getRating() {
        return this.incrementRating;
    }

    /**
     * This method returns the sponsored episode details in a readable format
     *
     * @return Returns all the properties of the SponsoredEpisode class
     */
    @Override
    public String toString() {
        return
                "SponsoredEpisode{" + "episodeName=" + this.getEpisodeName() +
                        ", sponsor='" + this.sponsor + '\'' +
                        ", incrementedRating=" + this.incrementRating +
                        '}';
    }
}
