/**
 * The Shape superclass by which all different types of
 * shapes will be inherited.
 *
 * @author Mohammad Salehi Vaziri
 * @version 1.0
 */
public abstract class Shape {
    /**
     * Calculate shape's perimeter.
     * each type of shape will implement this method for itself.
     *
     * @return the perimeter
     */
    public abstract double calculatePerimeter();

    /**
     * Calculate shape's area.
     *each type of shape will implement this method for itself.
     *
     * @return the area
     */
    public abstract double calculateArea();

    /**
     * print shape's perimeter and area.
     */
    public void draw(){
        System.out.println(this.getClass().getName() + " -> Perimeter: " + calculatePerimeter() + "  Area: " + calculateArea());
    }

}
