/**
 * This class does some simple testing of the Point and Line classes.
 */
public class GeometryTester {

    static final double COMPARISONTHRESHOLD = 0.00001;

    /**
     *
     * @param a
     * @param b
     * @return stuff
     */
    public static boolean doubleEquals(double a, double b) {
        return Math.abs(a - b) < GeometryTester.COMPARISONTHRESHOLD;
    }

    /**
     * The method is in charge of testing the Point class.
     *
     * @return true if not mistakes were found, false otherwise.
     */
    public boolean testPointFailing() {
        boolean mistake = false;
        Point point1 = new Point(12, 2);
        Point point2 = new Point(9, -2);
        double d1 = point1.distance(point2);
        System.out.println("d1: " + d1);
        if (!doubleEquals(d1, 5)) {
            System.out.println("Test distance failed.");
            mistake = true;
        }

        return !mistake;
    }

    /**
     * The method is in charge of testing the Point class.
     *
     * @return true if not mistakes were found, false otherwise.
     */
    public boolean testPoint() {
        boolean mistake = false;
        Point point1 = new Point(12, 2);
        Point point2 = new Point(9, -2);

        double d1 = point1.distance(point2);
        double d2 = point2.distance(point1);
        if (!doubleEquals(d1, d2)) {
            System.out.println("Test distance symmetry failed.");
            mistake = true;
        }

        if (!doubleEquals(point1.getX(), 12)) {
            System.out.println("Test p1.getX() failed.");
            mistake = true;
        }
        if (!doubleEquals(point1.getY(), 2)) {
            System.out.println("Test p1.getY() failed.");
            mistake = true;
        }
        if (!doubleEquals(point1.distance(point1), 0)) {
            System.out.println("Test distance to self failed.");
            mistake = true;
        }
        if (!doubleEquals(point1.distance(point2), 5)) {
            System.out.println("Test distance failed.");
            mistake = true;
        }
        if (!point1.equals(point1)) {
            System.out.println("Equality to self failed.");
            mistake = true;
        }
        if (!point1.equals(new Point(12, 2))) {
            System.out.println("Equality failed.");
            mistake = true;
        }
        if (point1.equals(point2)) {
            System.out.println("Equality failed -- should not be equal.");
            mistake = true;
        }

        return !mistake;
    }

    /**
     * The method is in charge of testing the Line class.
     *
     * @return true if not mistakes were found, false otherwise.
     */
    public boolean testLine() {
        boolean mistakes = false;
        Line l1 = new Line(12, 2, 9, -2);
        Line l2 = new Line(0, 0, 20, 0);
        // Line l3 = new Line(9, 2, 12, -2);

        if (!l1.isIntersecting(l2)) {
            System.out.println("Test isIntersecting failed (1).");
            mistakes = true;
        }
        if (l1.isIntersecting(new Line(0, 0, 1, 1))) {
            System.out.println("Test isIntersecting failed (2).");
            mistakes = true;
        }
        Point intersectL1L2 = l1.intersectionWith(l2);
        if (!l1.middle().equals(intersectL1L2)) {
            System.out.println("Test intersectionWith middle failed.");
            mistakes = true;
        }

        return !mistakes;
    }

    /**
     * Main method, running tests on both the point and the line classes.
     *
     * @param args ignored.
     */
    public static void main(String[] args) {
        GeometryTester tester = new GeometryTester();
        if (tester.testPoint() && tester.testLine()) {
            System.out.println("Test Completed Successfully!");
        } else {
            System.out.println("Found failing tests.");
        }
    }
}
