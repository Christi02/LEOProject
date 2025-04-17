/**
 * This class is designed to model debris in space.
 *
 * @author Joseth Sanjay Valdez
 * @author Cristin Moreno
 * @version 1.0
 */
public class Debris extends SpaceObject{

    /** True if this debris has sister debris. */
    private boolean hasSisterDebris;

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
}
