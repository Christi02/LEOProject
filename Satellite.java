/**
 * This class is designed to model a satellite in space.
 *
 *
 * @author Joseth Sanjay Valdez
 * @author Christin Moreno
 * @version 1.0
 */

import java.util.Date;

public class Satellite extends SpaceObject{

    /** Indicates if the satellite is nominated for special tracking. */
    private boolean isNominated;

    /** Date when the satellite was nominated. */
    private Date nominatedAt;

    /** True if the satellite has an associated dossier. */
    private boolean hasDossier;

    /** The date when this satellite's information was last updated. */
    private Date lastUpdated;

    /** The total number of maneuvers recorded for this satellite. */
    private int allManeuvers;

    /** Number of days since this satellite was last observed. */
    private int daysSinceOb;

    /** Number of recent maneuvers (typically in the last 90 days). */
    private int recentManeuvers;

    /** The total delta-V over the last 90 days. */
    private double deltaV90day;


    // Constructor

    public Satellite(int recordId, int noradCatId, String satelliteName, String country,
                     String orbitType, int launchYear, String launchSite,
                     double longitude, double avgLongitude, double[] geohash,
                     boolean isNominated, boolean hasDossier, int daysOld,
                     int conjunctionCount, boolean isUnkObject) {
        this.recordId = recordId;
        this.noradCatId = noradCatId;
        this.satelliteName = satelliteName;
        this.country = country;
        this.orbitType = orbitType;
        this.launchYear = launchYear;
        this.launchSite = launchSite;
        this.longitude = longitude;
        this.avgLongitude = avgLongitude;
        this.geohash = geohash;
        this.isNominated = isNominated;
        this.hasDossier = hasDossier;
        this.daysOld = daysOld;
        this.conjunctionCount = conjunctionCount;
        this.isUnkObject = isUnkObject;
    }

    // Setters

    /**
     * Sets whether the satellite is nominated.
     * @param nominated true if the satellite is nominated, false otherwise
     */
    public void setNominated(boolean nominated) {

        this.isNominated = nominated;
    }

    /**
     * Sets the date when the satellite was nominated.
     * @param date the nomination date
     */
    public void setNominatedAt(Date date) {
        this.nominatedAt = date;
    }

    /**
     * Sets whether the satellite has a dossier.
     * @param dossier true if the satellite has a dossier, false otherwise
     */
    public void setDossier(boolean dossier) {
        this.hasDossier = dossier;
    }

    /**
     * Sets the date when the satellite's data was last updated.
     * @param date the last updated date
     */
    public void setLastUpdated(Date date) {
        this.lastUpdated = date;
    }

    /**
     * Sets the total number of maneuvers recorded for the satellite.
     * @param count the number of maneuvers
     */
    public void setAllManeuvers(int count) {
        this.allManeuvers = count;
    }

    /**
     * Sets the number of days since the object was last observed.
     * @param days the number of days
     */
    public void setDaysSinceOb(int days) {
        this.daysSinceOb = days;
    }

    /**
     * Sets the number of recent maneuvers performed by the satellite.
     * @param count the number of recent maneuvers
     */
    public void setRecentManeuvers(int count) {
        this.recentManeuvers = count;
    }

    /**
     * Sets the total delta-V over the past 90 days.
     * @param value the delta-V value
     */
    public void setDeltaV90Day(double value) {
        this.deltaV90day = value;
    }

    // Getters

    /**
     * Returns whether the satellite is nominated.
     * @return true if nominated, false otherwise
     */
    public boolean isNominated() {
        return isNominated;
    }

    /**
     * Returns the date when the satellite was nominated.
     * @return the nomination date
     */
    public Date getNominatedAt() {
        return nominatedAt;
    }

    /**
     * Returns whether the satellite has a dossier.
     * @return true if it has a dossier, false otherwise
     */
    public boolean hasDossier() {
        return hasDossier;
    }

    /**
     * Returns the date when the satellite was last updated.
     * @return the last updated date
     */
    public Date getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Returns the total number of maneuvers recorded.
     * @return the number of maneuvers
     */
    public int getAllManeuvers() {
        return allManeuvers;
    }

    /**
     * Returns the number of days since the object was last observed.
     * @return the number of days
     */
    public int getDaysSinceOb() {
        return daysSinceOb;
    }

    /**
     * Returns the number of recent maneuvers.
     * @return the number of recent maneuvers
     */
    public int getRecentManeuvers() {
        return recentManeuvers;
    }

    /**
     * Returns the delta-V over the last 90 days.
     * @return the delta-V
     */
    public double getDeltaV90Day() {
        return deltaV90day;
    }
