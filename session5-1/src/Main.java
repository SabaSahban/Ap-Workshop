/**
 * the class to run the program
 *
 * @author Mohammad Slaehi Vaziri
 * @version 1.0
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args not used
     */
    public static void main(String[] args) {

        Circle circle1 = new Circle(19);
        Circle circle11 = new Circle(19); // a similar circle to circle1 to check equals
        Circle circle2 = new Circle(3);
        Rectangle rect1 = new Rectangle(1,4);
        Rectangle rect11 = new Rectangle(1,4); // a similar rectangle to circle1 to check equals
        Rectangle rect2 = new Rectangle(8,5);
        Rectangle rect3 = new Rectangle(6,6);
        Triangle tri1 = new Triangle(2,2,2);
        Triangle tri11 = new Triangle(2,2,2); // a similar triangle to circle1 to check equals
        Triangle tri2 = new Triangle(4,4,6);
        System.out.println("************************ checking equals method ************************");
        System.out.println("circle1 and circle11 -> " + circle1.equals(circle11));
        System.out.println("rect1 and rect11 -> " + rect1.equals(rect11));
        System.out.println("tri1 and tri11 -> " + tri1.equals(tri11));
        System.out.println("tri1 and tri2 -> " + tri1.equals(tri2));

        System.out.println("************************ checking isSquare and isEquilateral methods ************************");
        if (tri1.isEquilateral())
            System.out.println("tri1 is equilateral");
        if (rect3.isSquare())
            System.out.println("rect3 is square");
        if ((tri2.isEquilateral()))
            System.out.println("tri2 is rqulateral");

        Paint paint = new Paint();
        paint.addCircle(circle1);
        paint.addCircle(circle2);
        paint.addRectangle(rect1);
        paint.addRectangle(rect2);
        paint.addRectangle(rect3);
        paint.addTriangle(tri1);
        paint.addTriangle(tri2);

        System.out.println("************************ draw all ************************");
        paint.drawAll();
        System.out.println("************************ print all ************************");
        paint.printAll();

    }
}
