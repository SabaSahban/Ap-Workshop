import java.util.ArrayList;

/**
 * holds three lists of circles, triangles and rectangles,
 * and methods to draw and print them.
 *
 * @author Mohammad Slaehi Vaziri
 * @version 1.0
 */
public class Paint {
    private ArrayList<Circle> circles;
    private ArrayList<Triangle> triangles;
    private ArrayList<Rectangle> rectangles;

    /**
     * Instantiates a new Paint.
     */
    public Paint() {
        circles = new ArrayList<>();
        triangles = new ArrayList<>();
        rectangles = new ArrayList<>();
    }

    /**
     * Add triangle.
     *
     * @param triangleToAdd the triangle to add
     */
    public void addTriangle(Triangle triangleToAdd){
        if (validTriangle(triangleToAdd.getSides())) //check if triangle given sides are valid
            triangles.add(triangleToAdd);
        else
            System.out.println("invalid triangle sides!");
    }

    /**
     * Add circle.
     *
     * @param circleToAdd the circle to add
     */
    public void addCircle(Circle circleToAdd){
        circles.add(circleToAdd);
    }

    /**
     * Add rectangle.
     *
     * @param rectangleToAdd the rectangle to add
     */
    public void addRectangle(Rectangle rectangleToAdd){
        rectangles.add(rectangleToAdd);
    }

    /**
     * Draws all shapes.
     */
    public void drawAll(){
        for (Circle circle: circles)
            circle.draw();
        for (Triangle triangle: triangles)
            triangle.draw();
        for (Rectangle rectangle: rectangles)
            rectangle.draw();
    }

    /**
     * Prints all shapes using toString.
     */
    public void printAll(){
        for (Circle circle: circles)
            System.out.println(circle.toString());
        for (Triangle triangle: triangles)
            System.out.println(triangle.toString());
        for (Rectangle rectangle: rectangles)
            System.out.println(rectangle.toString());

    }


    private boolean validTriangle(ArrayList<Integer> sides){
        int a = sides.get(0), b = sides.get(1), c = sides.get(2);
        return ((a + b) > c) && ((a + c) > b) && ((b + c) > a);
    }
}
