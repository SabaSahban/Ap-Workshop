import java.util.Objects;
/**
 * ،Circle class holds it's radius and methods to calculate
 * perimeter and area
 *
 * @author Mohammad Salehi Vaziri
 * @version 1.0
 */
public class Circle {

    private int radius;

    /**
     * Instantiates a new Circle.
     *
     * @param radius the radius
     */
    public Circle(int radius) {
        this.radius = radius;
    }

    /**
     * Gets radius.
     *
     * @return the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Calculate circle perimeter
     *
     * @return the perimeter
     */
    public double calculatePerimeter(){
        return 2 * 3.14 * radius;
    }

    /**
     * Calculate circle area
     *
     * @return the area
     */
    public double calculateArea(){
        return 3.14 * radius * radius;
    }

    /**
     * prints circle's perimeter and area.
     */
    public void draw(){
        System.out.println(this.getClass().getName() + " -> Perimeter: " + calculatePerimeter() + "  Area: " + calculateArea());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return getRadius() == circle.getRadius();
    }


    @Override
    public String toString() {
        return "Circle { " +
                "radius = " + radius +
                " }";
    }
}
