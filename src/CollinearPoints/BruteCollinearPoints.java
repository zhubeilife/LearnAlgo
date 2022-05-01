import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {
    private final Point[] points;
    private final int pointsNum;
    private List<LineSegment> segmentsList;
    private int numSegments;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] inputpoints) {
        if (inputpoints == null) {
            throw new IllegalArgumentException("argument to BruteCollinearPoints constructor is null");
        }

        this.pointsNum = inputpoints.length;
        this.points = new Point[this.pointsNum];
        for (int i = 0; i < inputpoints.length; i++) {
            if (inputpoints[i] == null) {
                throw new IllegalArgumentException("found null points");
            }
            this.points[i] = inputpoints[i];
        }

        Arrays.sort(this.points);
        for (int i = 0; i < this.points.length - 1; i++) {
            if (this.points[i].compareTo(this.points[i+1]) == 0) {
                throw new IllegalArgumentException("found duplicated points: " + this.points[i]);
            }
        }

        this.segmentsList = null;
        this.numSegments = 0;
    }

    // the number of line segments
    public int numberOfSegments() {
        if (this.segmentsList == null) {
            segments();
        }
        return this.numSegments;
    }

    private boolean checkfourpoints(Point p, Point q, Point r, Point s) {
        double slopepq = q.slopeTo(p);
        double slopepr = r.slopeTo(p);
        double slopeps = s.slopeTo(p);

        return slopepq == slopepr && slopepq == slopeps;
    }

    // the line segments
    public LineSegment[] segments() {

        if (this.segmentsList == null) {
            this.segmentsList = new ArrayList<LineSegment>();
            for (int i = 0; i < pointsNum - 3; i++) {
                for (int j = i+1; j < pointsNum - 2; j++) {
                    for (int k = j+1; k < pointsNum - 1; k++) {
                        for (int l = k+1; l < pointsNum; l++) {
                            // For simplicity, we will not supply any input to BruteCollinearPoints
                            // that has 5 or more collinear points.
                            if (checkfourpoints(points[i], points[j], points[k], points[l])) {
                                segmentsList.add(new LineSegment(points[i], points[l]));
                            }
                        }
                    }
                }
            }
            this.numSegments = this.segmentsList.size();
        }

        return segmentsList.toArray(LineSegment[]::new);
    }
}
