import java.util.ArrayList;
import java.util.Objects;

/**
 * ،Triangle class holds it's sides and methods to calculate
 * perimeter and area
 *
 * @author Mohammad Slaehi Vaziri
 * @version 1.0
 */
public class Triangle {

    private ArrayList<Integer> sides;

    /**
     * Instantiates a new Triangle.
     *
     * @param a the first side
     * @param b the second side
     * @param c the third side
     */
    public Triangle (int a, int b, int c){
        sides = new ArrayList<>();
        sides.add(a);
        sides.add(b);
        sides.add(c);
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
     * check if the triangle is equilateral
     *
     * @return true if it is equilateral, false if not
     */
    public boolean isEquilateral(){
        int a = sides.get(0), b = sides.get(1), c = sides.get(2);
        return a == c && b == c;
    }

    /**
     * Calculate triangle perimeter.
     *
     * @return the perimeter
     */
    public double calculatePerimeter(){
        return sides.get(0) + sides.get(1) + sides.get(2);
    }

    /**
     * Calculate triangle area using heron formula.
     *
     * @return the area
     */
    public double calculateArea(){

        int a = sides.get(0), b = sides.get(1), c = sides.get(2);
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }


    /**
     * prints triangle's perimeter and area.
     */
    public void draw(){
        System.out.println(this.getClass().getName() + " -> Perimeter: " + calculatePerimeter() + "  Area: " + calculateArea());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(getSides(), triangle.getSides());
    }

    @Override
    public String toString() {
        return "Triangle { " +
                "sides = " + sides +
                " }";
    }
}
