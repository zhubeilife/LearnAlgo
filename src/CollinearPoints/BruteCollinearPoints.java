import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {
    private Point[] points;
    private int pointsNum;
    private LineSegment[] segments;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] inputpoints) {
        if (inputpoints == null) {
            throw new IllegalArgumentException("argument to BruteCollinearPoints constructor is null");
        }

        for (int i = 0; i < inputpoints.length; i++) {
            if (inputpoints[i] == null) {
                throw new IllegalArgumentException("found null points");
            }
        }

        Arrays.sort(inputpoints);
        for (int i = 0; i < inputpoints.length - 1; i++) {
            if (inputpoints[i].compareTo(inputpoints[i+1]) == 0) {
                throw new IllegalArgumentException("found duplicated points: " + inputpoints[i]);
            }
        }

        this.points = inputpoints;
        this.pointsNum = inputpoints.length;
        this.segments = null;
    }

    // the number of line segments
    public int numberOfSegments() {
        if (this.segments == null) {
            segments();
        }
        return segments.length;
    }

    private boolean checkfourpoints(Point p, Point q, Point r, Point s) {
        double slopepq = q.slopeTo(p);
        double slopepr = r.slopeTo(p);
        double slopeps = s.slopeTo(p);

        return slopepq == slopepr && slopepq == slopeps;
    }

    // the line segments
    public LineSegment[] segments() {
        List<LineSegment> segmentsList = new ArrayList<LineSegment>();
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

        this.segments = segmentsList.toArray(LineSegment[]::new);
        return this.segments;
    }
}
