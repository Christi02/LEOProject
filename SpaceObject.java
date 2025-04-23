/**
 * This class is designed to model an object in space, whether it be debris or a satellite.
 *
 *
 * @author Joseth Sanjay Valdez
 * @author Christin Moreno
 * @version 1.0
 */

public abstract class SpaceObject {

    /** ID used to keep track of this record. */
    protected  int recordId;

    /** Catalog number from norad. */
    protected  int noradCatId;

    /** Name of the object (satellite, rocket part, etc.). */
    protected  String satelliteName;

    /** Country that launched or owns it. */
    protected  String country;

    protected String approximateOrbitType;

    protected String orbitType;

    /** What kind of object it is. Like satellite or debris. */
    protected  String objectType;

    /** The year when it was launched. */
    protected  int launchYear;

    /** Where it was launched from. */
    protected  String launchSite;

    /** Current longitude position. */
    protected  double longitude;

    /** The average longitude of the object’s orbit. */
    protected  double avgLongitude;

    /** A geohash value to roughly locate the object’s position. */
    protected  double[] geohash = new double[2];

    /** True if the object is nominated for a specific project or tracking. */
    protected  boolean isNominated;

    /** True if the object has a full dossier with details on its status. */
    protected  boolean hasDossier;

    /** The number of days since the object was launched or tracked. */
    protected  int daysOld;

    /** The number of times the object has been involved in a conjunction event. */
    protected  int conjunctionCount;

    /** True if the object is classified as an unknown object in the system. */
    protected boolean isUnkObject;


    // Setters

    /**
     * Sets the unique record ID for this object.
     *
     * @param id the ID that identifies this record
     */
    public void setRecordId(int id) {
        this.recordId = id;
    }

    /**
     * Sets the NORAD catalog ID.
     *
     * @param id the NORAD ID assigned to the object
     */
    public void setNoradCatId(int id) {
        this.noradCatId = id;
    }

    /**
     * Sets the name of the space object.
     *
     * @param satelliteName the name or label of the object
     */
    public void setName(String satelliteName) {
        this.satelliteName = satelliteName;
    }

    /**
     * Sets the country that owns or launched the object.
     *
     * @param country the country name or code
     */
    public void setCountry(String country) {
        this.country = country;
    }

    public void setApproximateOrbitType(String approximateOrbitType) {
        this.approximateOrbitType = approximateOrbitType;
    }

    public void setOrbitType(String orbitType) {
        this.orbitType = orbitType;
    }

    /**
     * Sets the type of object (like satellite, debris, etc.).
     *
     * @param objectType what kind of object this is
     */
    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    /**
     * Sets the launch year as an integer.
     *
     * @param year the year the object was launched
     */
    public void setLaunchYear(int year) {
        this.launchYear = year;
    }

    /**
     * Sets the launch site location.
     *
     * @param site the launch site’s name or code
     */
    public void setLaunchSite(String site) {
        this.launchSite = site;
    }

    /**
     * Sets the current longitude of the object.
     *
     * @param lon the object’s current longitude position
     */
    public void setLongitude(double lon) {
        this.longitude = lon;
    }

    /**
     * Sets the average longitude of the object’s orbit.
     *
     * @param avgLongitude the average longitude over time
     */
    public void setAvgLongitude(double avgLongitude) {
        this.avgLongitude = avgLongitude;
    }

    /**
     * Sets the geohash value to estimate the object’s location.
     *
     * @param latitude a geohash representation of the latitude
     * @param longitude a geohash representation of the longitude
     */
    public void setGeohash(double latitude, double longitude) {
        geohash[0] = latitude;
        geohash[1] = longitude;
    }

    /**
     * Sets whether the object is nominated for tracking or special projects.
     *
     * @param isNominated true if it’s nominated
     */
    public void setIsNominated(boolean isNominated) {
        this.isNominated = isNominated;
    }

    /**
     * Sets whether the object has a dossier with additional data.
     *
     * @param hasDossier true if there's a dossier available
     */
    public void setHasDossier(boolean hasDossier) {
        this.hasDossier = hasDossier;
    }

    /**
     * Sets the number of days since the object was launched or tracked.
     *
     * @param daysOld how many days old the object is
     */
    public void setDaysOld(int daysOld) {
        this.daysOld = daysOld;
    }

    /**
     * Sets the count of conjunction events this object has been involved in.
     *
     * @param conjunctionCount how many conjunctions it’s had
     */
    public void setConjunctionCount(int conjunctionCount) {
        this.conjunctionCount = conjunctionCount;
    }

    /**
     * Sets whether the object is marked as an unknown object in the system.
     *
     * @param isUnkObject true if it’s unidentified
     */
    public void setIsUnkObject(boolean isUnkObject) {
        this.isUnkObject = isUnkObject;
    }


// Getters

    /**
     * Gets the unique record ID.
     *
     * @return the ID of this record
     */
    public int getRecordId() {
        return recordId;
    }

    /**
     * Gets the NORAD catalog ID.
     *
     * @return the NORAD ID
     */
    public int getNoradCatId() {
        return noradCatId;
    }

    /**
     * Gets the name of the space object.
     *
     * @return the object’s name
     */
    public String getSatelliteName() {
        return satelliteName;
    }

    /**
     * Gets the country that owns or launched the object.
     *
     * @return the name of the country
     */
    public String getCountry() {
        return country;
    }
    /**
     * Gets the approximate orbit type of the object.
     *
     * @return the approximate orbit type
     */
    public String getApproximateOrbitType() {
        return approximateOrbitType;
    }

    /**
     * Gets the orbit type of the object.
     *
     * @return the orbit type
     */
    public String getOrbitType() {
        return orbitType;
    }

    /**
     * Gets the type of the object (satellite, debris, etc.).
     *
     * @return what kind of object it is
     */
    public String getObjectType() {
        return objectType;
    }

    /**
     * Gets the launch year.
     *
     * @return the year the object launched
     */
    public int getLaunchYear() {
        return launchYear;
    }

    /**
     * Gets the name or code of the launch site.
     *
     * @return the site where it launched
     */
    public String getLaunchSite() {
        return launchSite;
    }

    /**
     * Gets the current longitude position.
     *
     * @return the longitude value
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Gets the average longitude of the object’s orbit.
     *
     * @return the average orbital longitude
     */
    public double getAvgLongitude() {
        return avgLongitude;
    }

    /**
     * Gets the geohash representing the object’s approximate position.
     *
     * @return a geohash location value
     */
    public double[] getGeohash() {
        // return a copy if you want to guard against external modification:
        return new double[]{ geohash[0], geohash[1] };
    }

    /**
     * Checks if the object is nominated for tracking or a project.
     *
     * @return true if nominated
     */
    public boolean isNominated() {
        return isNominated;
    }

    /**
     * Checks if the object has a dossier with extra information.
     *
     * @return true if it has a dossier
     */
    public boolean hasDossier() {
        return hasDossier;
    }

    /**
     * Gets the number of days since the object was launched or tracked.
     *
     * @return how old the object is in days
     */
    public int getDaysOld() {
        return daysOld;
    }

    /**
     * Gets the count of conjunction events for this object.
     *
     * @return how many conjunctions it’s been in
     */
    public int getConjunctionCount() {
        return conjunctionCount;
    }

    /**
     * Checks if the object is considered unknown.
     *
     * @return true if it’s unknown
     */
    public boolean isUnkObject() {
        return isUnkObject;
    }
}
