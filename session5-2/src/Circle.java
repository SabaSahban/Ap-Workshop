/**
 * The Circle type of shape.
 *
 * @author Mohammad Salehi Vaziri
 * @version 1.0
 */
public class Circle extends Shape{

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

    public double calculatePerimeter(){
        return 2 * 3.14 * radius;
    }

    public double calculateArea(){
        return 3.14 * radius * radius;
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
