import java.util.Objects;

/**
 * The rectangle type of polygon
 *
 * @author Mohammad Salehi Vaziri
 * @version 1.0
 */
public class Rectangle extends Polygon{


    /**
     * Instantiates a new Rectangle.
     *
     * @param sides1 the sides 1
     */
    public Rectangle(Integer... sides1) {
        super(sides1);
    }

    public double calculatePerimeter(){
        return 2 * (getSides().get(0) + getSides().get(1));
    }

    public double calculateArea(){
        return getSides().get(0) * getSides().get(1);
    }


    /**
     * check if a rectangle is square.
     *
     * @return true if it is square, false if not
     */
    public boolean isSquare(){
        return getSides().get(0).equals(getSides().get(1));
    }

}
