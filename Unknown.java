
/**
 * This class is designed to model debris in space.
 *
 * @author Christin Moreno
 * @author Joseth Sanjay Valdez
 * @version 1.0
 */
public class Unknown extends SpaceObject{

    public Unknown(
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
            boolean isUnkObject
    ){
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
        if(geohash != null && geohash.length == 2){
            this.geohash[0] = geohash[0];
            this.geohash[1] = geohash[1];
        }

        this.isNominated = isNominated;
        this.hasDossier = hasDossier;
        this.daysOld = daysOld;
        this.conjunctionCount = conjunctionCount;
        this.isUnkObject = isUnkObject;
    }
    public static void printUnknownList(Unknown[] unknownArr){
        for(Unknown unknown : unknownArr){
            if(unknown != null){
                System.out.println("Record ID: " + unknown.getRecordId());
                System.out.println("Satellite Name: " + unknown.getSatelliteName());
                System.out.println("Country: " + unknown.getCountry());
                System.out.println("Orbit Type: " + unknown.getOrbitType());
                System.out.println("Launch Year: " + unknown.getLaunchYear());
                System.out.println("Launch Site: " + unknown.getLaunchSite());
                System.out.println("Longitude: " + unknown.getLongitude());
                System.out.println("Avg. Longitude: " + unknown.getAvgLongitude());
                System.out.println("Geohash: [" + unknown.getGeohash()[0] + ", " + unknown.getGeohash()[1] + "]");
                System.out.println("Days Old: " + unknown.getDaysOld());
                System.out.println("----------------------------------------------------");
            }
        }
    }
}
