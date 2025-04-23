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

    String[] data;


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
    public Debris(String[] parts){
        this.data = parts;
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
    /**
     * Checks if the debris is still in orbit or has exited returning a boolean
     * 
     * @author Christin Moreno
     * @author Joseth Sanjay Valdez
     * @param debrisArray
     * @return if the debris is still in orbit or has exited 
     */
    public static boolean stillInOrbit(Debris[] debrisArray){
        boolean inOrbit =  true;
        for(Debris debris : debrisArray){
            if(debris == null){
                continue;
            }
            if((debris.approximateOrbitType.equalsIgnoreCase("Unknown Orbit Category" ))  && (debris.getLongitude() == 0)
            && (debris.getDaysOld() > 15000) && (debris.getConjunctionCount() == 0)){
                inOrbit = false;
            }
        }
        return inOrbit;
    }

    /**
     * Calculates the risk level of each debris for the updated CSV file.
     * 
     * @author Christin Moreno
     * @author Joseth Sanjay Valdez
     * @param debrisArray
     * @return The risk level of the debris 
     */
    public static String riskLevel(Debris[] debrisArray){
        double orbitalDrift = 0.0;
        String rLevel = "";
        for(Debris debris : debrisArray){
            if(debris == null){
                continue;
            }
             orbitalDrift = Math.abs(debris.longitude - debris.avgLongitude);
             if(orbitalDrift > 50){
                rLevel = "High Risk";
             }
             else if(orbitalDrift > 10){
                rLevel = "Moderate Risk";
             }
             else{
                rLevel = "Low Risk";
             }
        }
        return rLevel;
    }

}
