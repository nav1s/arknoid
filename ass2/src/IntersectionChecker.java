
/**
 * this class checks whether two lines intersects.
 */
public class IntersectionChecker {
    private Line line1;
    private Line line2;
    private Point intersectionPoint;
    private boolean isIntersecting;

    /**
     * @param line1 the first line we want to check if intersects
     * @param line2 the second line we want to check if intersects
     */
    public IntersectionChecker(Line line1, Line line2) {
        this.line1 = line1;
        this.line2 = line2;
        this.process();
    }

    /**
     * generate relevant data about the lines we have.
     */
    private void process() {
        Point start1 = line1.getStart();
        Point start2 = line2.getStart();

        Point end1 = line1.getEnd();
        Point end2 = line2.getEnd();

        double x1 = start1.getX();
        double y1 = start1.getY();

        double x2 = end1.getX();
        double y2 = end1.getY();

        double x3 = start2.getX();
        double y3 = start2.getY();

        double x4 = end2.getX();
        double y4 = end2.getY();

        double a = ((x4 - x3) * (y3 - y1) - (y4 - y3) * (x3 - x1));
        double b = ((x4 - x3) * (y2 - y1) - (y4 - y3) * (x2 - x1));
        double c = ((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1));

        if (b == 0) {
            if (a == 0) {
                this.isIntersecting = true;
                return;
            }
            this.isIntersecting = false;
            return;
        }

        double alpha = a / b;
        double beta = c / b;
        if (alpha >= 0 && alpha <= 1 && beta >= 0 && beta <= 1) {
            double x0 = x1 + alpha * (x2 - x1);
            double y0 = y1 + alpha * (y2 - y1);
            this.isIntersecting = true;
            this.intersectionPoint = new Point(x0, y0);
            return;
        }
        this.isIntersecting = false;

    }

    /**
     * @return the intersection point between the two lines
     */
    public Point getIntersectionPoint() {
        return intersectionPoint;
    }

    /**
     * @return true if the two lines intersect, otherwise false
     */
    public boolean isIntersecting() {
        return isIntersecting;
    }

}