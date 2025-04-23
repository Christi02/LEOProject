
/**
     * This class is designed to track objects in LEO.
     *
     * @author Christin Moreno
     * @author Joseth Sanjay Valdez
     * @version 1.0
     */
public class TrackObjectsInLEO extends SpaceObject{

    public TrackObjectsInLEO(
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
    public static void printLEOList(TrackObjectsInLEO[] leoArr){
        for(TrackObjectsInLEO leoList : leoArr){
            if(leoList != null){
                System.out.println("Record ID: " + leoList.getRecordId());
                System.out.println("Satellite Name: " + leoList.getSatelliteName());
                System.out.println("Country: " + leoList.getCountry());
                System.out.println("Orbit Type: " + leoList.getOrbitType());
                System.out.println("Launch Year: " + leoList.getLaunchYear());
                System.out.println("Launch Site: " + leoList.getLaunchSite());
                System.out.println("Longitude: " + leoList.getLongitude());
                System.out.println("Avg. Longitude: " + leoList.getAvgLongitude());
                System.out.println("Geohash: [" + leoList.getGeohash()[0] + ", " + leoList.getGeohash()[1] + "]");
                System.out.println("Days Old: " + leoList.getDaysOld());
                System.out.println("----------------------------------------------------");
            }
        }
    }
}
