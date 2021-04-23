import javax.print.DocFlavor;
import java.util.ArrayList;

/**
 * The Paint class holds a list of shapes and methods
 * to draw and print them.
 *
 * @author Mohammad Salehi Vaziri
 * @version 1.0
 */
public class Paint {

    private ArrayList<Shape> shapes;

    /**
     * Instantiates a new Paint.
     */
    public Paint() {
        shapes = new ArrayList<>();
    }

    /**
     * Add shape.
     *
     * @param shapeToAdd the shape to add
     */
    public void addShape(Shape shapeToAdd){
        shapes.add(shapeToAdd);
    }

    /**
     * Draw all shapes.
     */
    public void drawAll(){
        for (Shape shape : shapes)
            shape.draw();
    }

    /**
     * Print all shapes.
     */
    public void printAll(){
        for (Shape shape: shapes)
            System.out.println(shape.toString());
    }

    /**
     * print triangles or rectangles that have equal sides.
     */
    public void describeEqualSides(){
        for (Shape shape : shapes){
            if (shape instanceof Rectangle) {
                if (((Rectangle) shape).isSquare())
                    System.out.println(shape.toString() + " ----> it is square");
            }
            else if (shape instanceof Triangle){
                if (((Triangle) shape).isEquilateral())
                    System.out.println(shape.toString() + " ----> it is equilateral");
            }
        }
    }
}
