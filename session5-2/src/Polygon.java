import java.util.ArrayList;
import java.util.Objects;

/**
 * The Polygon type of shape.
 *
 * @author Mohammad Salehi Vaziri
 * @version 1.0
 */
public abstract class Polygon extends Shape {

    private ArrayList<Integer> sides;

    /**
     * Instantiates a new Polygon.
     *
     * @param sides1 the sides of polygon
     */
    public Polygon(Integer... sides1) {
        sides = new ArrayList<>();
        for (Integer side: sides1)
            sides.add(side);
    }

    /**
     * Gets sides.
     *
     * @return the sides
     */
    public ArrayList<Integer> getSides() {
        return sides;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polygon)) return false;
        Polygon polygon = (Polygon) o;
        return Objects.equals(getSides(), polygon.getSides());
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " { " +
                "sides = " + sides +
                " }";
    }
}
