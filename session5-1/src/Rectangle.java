import java.util.ArrayList;
import java.util.Objects;

/**
 * ،Rectangle class holds it's sides and methods to calculate
 * perimeter and area
 *
 * @author Mohammad Salehi Vaziri
 * @version 1.0
 */
public class Rectangle {

    private ArrayList<Integer> sides;

    /**
     * Instantiates a new Rectangle.
     *
     * @param a the length
     * @param b the width
     */
    public Rectangle(int a, int b) {
        sides = new ArrayList<>();
        sides.add(a);
        sides.add(b);
    }

    /**
     * Gets sides.
     *
     * @return the sides
     */
    public ArrayList<Integer> getSides() {
        return sides;
    }

    /**
     * checks if the rectangle is square
     *
     * @return true if it is square, false if not
     */
    public boolean isSquare(){
        return sides.get(0).equals(sides.get(1));
    }

    /**
     * Calculate rectangle perimeter.
     *
     * @return the perimeter
     */
    public double calculatePerimeter(){
        return 2 * (sides.get(0) + sides.get(1));
    }

    /**
     * Calculate rectangle area.
     *
     * @return the area
     */
    public double calculateArea(){
        return sides.get(0) * sides.get(1);
    }

    /**
     * prints rectangle's perimeter and area.
     */
    public void draw(){
        System.out.println(this.getClass().getName() + " -> Perimeter: " + calculatePerimeter() + "  Area: " + calculateArea());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(getSides(), rectangle.getSides());
    }

    @Override
    public String toString() {
        return "Rectangle { " +
                "sides = " + sides +
                " }";
    }
}
