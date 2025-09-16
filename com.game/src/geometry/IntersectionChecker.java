package geometry;

/**
 * this class checks whether two lines intersects.
 */
public class IntersectionChecker {
    private Line line1;
    private Line line2;
    private Point intersectionPoint = null;
    private boolean isIntersecting = false;

    /**
     * @param line1 the first line we want to check if intersects
     * @param line2 the second line we want to check if intersects
     */
    public IntersectionChecker(Line line1, Line line2) {
        this.line1 = line1;
        this.line2 = line2;
        this.isIntersecting = this.checkIntersection();
        if(this.isIntersecting){
            this.intersectionPoint = this.findIntersectionPoint();
        }
    }
    
    /**
     * Determines the orientation of three points (p, q, r).
     * @param p the first point
     * @param p the second point
     * @param p the third point
     * Returns:
     * 0 - Collinear
     * 1 - Clockwise
     * 2 - Counterclockwise
     */
    private static int orientation(Point p, Point q, Point r) {
        double val = (q.getY() - p.getY()) * (r.getX() - q.getX()) - (q.getX() - p.getX()) * (r.getY() - q.getY());
        
        if (Math.abs(val) < 1e-10) return 0; // collinear
        return (val > 0) ? 1 : 2; // clockwise or counterclockwise
    }
    
    /**
     * Checks if point q lies on segment pr.
     * @param p the first point
     * @param p the second point
     * @param p the third point
     */
    private static boolean onSegment(Point p, Point q, Point r) {
        return q.getX() <= Math.max(p.getX(), r.getX()) && q.getX() >= Math.min(p.getX(), r.getX()) &&
               q.getY() <= Math.max(p.getY(), r.getY()) && q.getY() >= Math.min(p.getY(), r.getY());
    }
    
    /**
     * Checks if two line segments intersect.
     * @return true if the segments intersect, false otherwise
     */
    public boolean checkIntersection(){
        Point p1 = line1.getStart();
        Point q1 = line1.getEnd();
        Point p2 = line2.getStart();
        Point q2 = line2.getEnd();
        
        // Find the four orientations needed for general and special cases
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);
                
        // General case
        if (o1 != o2 && o3 != o4)
            return true;
        
        // Special Cases
        // p1, q1 and p2 are collinear and p2 lies on segment p1q1
        if (o1 == 0 && onSegment(p1, p2, q1)) return true;
        
        // p1, q1 and q2 are collinear and q2 lies on segment p1q1
        if (o2 == 0 && onSegment(p1, q2, q1)) return true;
        
        // p2, q2 and p1 are collinear and p1 lies on segment p2q2
        if (o3 == 0 && onSegment(p2, p1, q2)) return true;
        
        // p2, q2 and q1 are collinear and q1 lies on segment p2q2
        if (o4 == 0 && onSegment(p2, q1, q2)) return true;
        
        return false;
    }

    /**
     * Calculates the intersection point of two line segments.
     * @return the intersection point, or null if the segments don't intersect
     */
    public Point findIntersectionPoint() {
        Point p1 = this.line1.getStart();
        Point p2 = this.line1.getEnd();
        Point p3 = this.line2.getStart();
        Point p4 = this.line2.getEnd();
        
        // Calculate denominator
        double denominator = (p1.getX() - p2.getX()) * (p3.getY() - p4.getY()) - (p1.getY() - p2.getY()) * (p3.getX() - p4.getX());
        
        // If lines are parallel or collinear
        if (Math.abs(denominator) < 1e-10) {
            // Check if they're collinear and overlapping
            if (orientation(p1, p2, p3) == 0) {
                // Return one of the overlapping points
                if (onSegment(p1, p3, p2)) return p3;
                if (onSegment(p1, p4, p2)) return p4;
                if (onSegment(p3, p1, p4)) return p1;
                if (onSegment(p3, p2, p4)) return p2;
            }
            return null;
        }
        
        // Calculate t and s
        double t = ((p1.getX() - p3.getX()) * (p3.getY() - p4.getY()) - (p1.getY() - p3.getY()) * (p3.getX() - p4.getX())) / denominator;
        double s = ((p1.getX() - p3.getX()) * (p1.getY() - p2.getY()) - (p1.getY() - p3.getY()) * (p1.getX() - p2.getX())) / denominator;
        
        // Check if the intersection is within both line segments
        if (t < 0 || t > 1 || s < 0 || s > 1) {
            return null;
        }
        
        // Calculate the intersection point
        double x = p1.getX() + t * (p2.getX() - p1.getX());
        double y = p1.getY() + t * (p2.getY() - p1.getY());
        
        return new Point(x, y);
    }

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
