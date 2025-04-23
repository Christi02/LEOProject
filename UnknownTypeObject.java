public class UnknownTypeObject extends SpaceObject {
    /**
     * This class is designed to model unknown-type space objects.
     *
     * @author Joseth Sanjay Valdez
     * @author Cristin Moreno
     * @version 1.0
     */

    public UnknownTypeObject(
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
    }

    public static void printUnknownObjectsData(UnknownTypeObject[] objects) {
        for (UnknownTypeObject obj : objects) {
            if (obj != null) {
                System.out.println("Record ID: " + obj.getRecordId());
                System.out.println("Satellite Name: " + obj.getSatelliteName());
                System.out.println("Country: " + obj.getCountry());
                System.out.println("Orbit Type: " + obj.getOrbitType());
                System.out.println("Launch Year: " + obj.getLaunchYear());
                System.out.println("Launch Site: " + obj.getLaunchSite());
                System.out.println("Longitude: " + obj.getLongitude());
                System.out.println("Avg. Longitude: " + obj.getAvgLongitude());
                System.out.println("Geohash: [" + obj.getGeohash()[0] + ", " + obj.getGeohash()[1] + "]");
                System.out.println("Days Old: " + obj.getDaysOld());
                System.out.println("----------------------------------------------------");
            }
        }
    }
}
