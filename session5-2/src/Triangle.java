import java.util.Objects;

/**
 * The triangle type of polygon
 *
 * @author Mohammad Salehi Vaziri
 * @version 1.0
 */
public class Triangle extends Polygon{

    /**
     * Instantiates a new Triangle.
     *
     * @param sides1 the sides of triangle
     */
    public Triangle(Integer... sides1) {
        super(sides1);
    }

    public double calculatePerimeter(){
        return getSides().get(0) + getSides().get(1) + getSides().get(2);
    }
    public double calculateArea(){
        int a = getSides().get(0), b = getSides().get(1), c = getSides().get(2);
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /**
     * check if a triangle is Equilateral
     *
     * @return true if it is Equilateral, false if not
     */
    public boolean isEquilateral(){
        int a = getSides().get(0), b = getSides().get(1), c = getSides().get(2);
        return a == c && b == c;
    }


}