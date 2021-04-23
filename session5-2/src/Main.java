/**
 * The calss to run the program
 *
 * @author Mohammad Salehi Vaziri
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
        Circle circle11 = new Circle(19);
        Circle circle2 = new Circle(3);
        Rectangle rect1 = new Rectangle(1,4);
        Rectangle rect11 = new Rectangle(1,4);
        Rectangle rect2 = new Rectangle(8,5);
        Rectangle rect3 = new Rectangle(6,6);
        Triangle tri1 = new Triangle(2,2,2);
        Triangle tri11 = new Triangle(2,2,2);
        Triangle tri2 = new Triangle(4,4,6);
        System.out.println("************************ checking equals method ************************");
        System.out.println("circle1 and circle11 -> " + circle1.equals(circle11));
        System.out.println("rect1 and rect11 -> " + rect1.equals(rect11));
        System.out.println("tri1 and tri11 -> " + tri1.equals(tri11));
        System.out.println("tri1 and tri2 -> " + tri1.equals(tri2));

        Paint paint = new Paint();
        paint.addShape(circle1);
        paint.addShape(circle2);
        paint.addShape(rect1);
        paint.addShape(rect2);
        paint.addShape(rect3);
        paint.addShape(tri1);
        paint.addShape(tri2);

        System.out.println("************************ draw all ************************");
        paint.drawAll();
        System.out.println("************************ print all ************************");
        paint.printAll();
        System.out.println("************************ equal sides ************************");
        paint.describeEqualSides();

    }
}
