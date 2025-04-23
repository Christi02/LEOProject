/**
 * This class is designed to model debris in space.
 *
 * @author Joseth Sanjay Valdez
 * @author Christin Moreno
 * @version 1.0
 */
public class Debris extends SpaceObject{

    /** True if this debris has sister debris. */
    protected boolean hasSisterDebris;


    public Debris(
            int recordId,
            int noradCatId,
            String satelliteName,
            String country,
            String orbitType,
            String objectType,
            int launchYear,
            String launchSite,
            double longitude,
            double avgLongitude,
            double[] geohash,
            boolean isNominated,
            boolean hasDossier,
            int daysOld,
            int conjunctionCount,
            boolean isUnkObject,
            boolean hasSisterDebris
    ) {
        this.recordId = recordId;
        this.noradCatId = noradCatId;
        this.satelliteName = satelliteName;
        this.country = country;
        this.orbitType = orbitType;
        this.objectType = objectType;
        this.launchYear = launchYear;
        this.launchSite = launchSite;
        this.longitude = longitude;
        this.avgLongitude = avgLongitude;
        if (geohash != null && geohash.length == 2) {
            this.geohash[0] = geohash[0];
            this.geohash[1] = geohash[1];
        }
        this.isNominated = isNominated;
        this.hasDossier = hasDossier;
        this.daysOld = daysOld;
        this.conjunctionCount = conjunctionCount;
        this.isUnkObject = isUnkObject;
        this.hasSisterDebris = hasSisterDebris;
    }


    /**
     * Sets whether this debris has a sister debris.
     *
     * @param hasSister true if there’s a known related piece of debris
     */
    public void setHasSisterDebris(boolean hasSister) {
        this.hasSisterDebris = hasSister;
    }

    /**
     * Returns true if this debris has a related "sister" debris.
     *
     * @return true if sister debris exists
     */
    public boolean hasSisterDebris() {
        return hasSisterDebris;
    }

    public static void printDebrisData(Debris[] debrisArray) {
        for (Debris debris : debrisArray) {
            if (debris != null) {
                System.out.println("Record ID: " + debris.getRecordId());
                System.out.println("Satellite Name: " + debris.getSatelliteName());
                System.out.println("Country: " + debris.getCountry());
                System.out.println("Orbit Type: " + debris.getOrbitType());
                System.out.println("Launch Year: " + debris.getLaunchYear());
                System.out.println("Launch Site: " + debris.getLaunchSite());
                System.out.println("Longitude: " + debris.getLongitude());
                System.out.println("Avg. Longitude: " + debris.getAvgLongitude());
                System.out.println("Geohash: [" + debris.getGeohash()[0] + ", " + debris.getGeohash()[1] + "]");
                System.out.println("Days Old: " + debris.getDaysOld());
                System.out.println("----------------------------------------------------");
            }
        }
    }
}
