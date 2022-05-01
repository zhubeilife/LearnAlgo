import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {
    private final Point[] points;
    private final int pointsNum;
    private LineSegment[] segments;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] inputpoints) {
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

        this.segments = null;
    }

    // the number of line segments
    public int numberOfSegments() {
        if (this.segments == null) {
            segments();
        }
        return segments.length;
    }

    private static void copylist(Point[] copyfrom, Point[] copyto) {
        for (int i = 0; i < copyfrom.length; i++) {
            copyto[i] = copyfrom[i];
        }
    }

    private static void findcollinear(Point[] points, List<LineSegment> segmentsList) {
        Point orgin = points[0];
        int currentminindex = 1;

        for (int i = 2; i < points.length; i++) {
            int collinear = orgin.slopeOrder().compare(points[currentminindex], points[i]);
            if (collinear != 0) {
                if (i - currentminindex >= 3) {
                    // find one
                    // only return the one origin is on the edge
                    if (orgin.compareTo(points[currentminindex]) < 0) {
                        segmentsList.add(new LineSegment(orgin, points[i - 1]));
                    }
                }
                currentminindex = i;
            } else if (i == points.length - 1) {
                if (i - currentminindex >= 3) {
                    // find one
                    // only return the one origin is on the edge
                    if (orgin.compareTo(points[currentminindex]) < 0) {
                        segmentsList.add(new LineSegment(orgin, points[i]));
                    }
                }
            }
       }
    }

    // the line segments
    public LineSegment[] segments() {
        List<LineSegment> segmentsList = new ArrayList<LineSegment>();
        Point[] auxpoints = new Point[pointsNum];

        for (int i = 0; i < pointsNum; i++) {
            copylist(this.points, auxpoints);
            Arrays.sort(auxpoints, points[i].slopeOrder());
            findcollinear(auxpoints, segmentsList);
        }

        this.segments = segmentsList.toArray(LineSegment[]::new);
        return this.segments;
    }
}
