/**
 * 7st submit refer to use two uf to solve this questions
 * https://nancyyihao.github.io/2017/12/24/Coursera-Algorithm-Part-One-Percolation/
 *
 */


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int size;
    private int openSites;
    private boolean[][] sites;
    private boolean isPercolation = false;
    private final WeightedQuickUnionUF uf;
    private final WeightedQuickUnionUF ufPer;
    private final int ufTopIndex;
    private final int ufBottomIndex;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("The number should be larger than 0");
        }
        size = n;
        openSites = 0;
        sites = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sites[i][j] = false;
            }
        }
        uf = new WeightedQuickUnionUF(n *n + 1);
        ufPer = new WeightedQuickUnionUF(n *n + 2);
        ufTopIndex = n * n;
        ufBottomIndex = n * n + 1;
    }

    private boolean checkRange(int n) {
        return (n >= 1) && (n <= size);
    }

    private boolean checkPose(int row, int col) {
        return checkRange(row) && checkRange(col);
    }

    private void checkPoseThrow(int row, int col) {
        if (!checkPose(row, col)) {
            throw new IllegalArgumentException("Range is not right");
        }
    }

    private int getUFIndex(int row, int col) {
        return col - 1 + size * (row - 1);
    }

    private void connectSite(int row, int col, int rowInc, int colInc) {
        int surroundRow = row + rowInc;
        int surroundCol = col + colInc;

        if (checkPose(surroundRow, surroundCol) && isOpen(surroundRow, surroundCol)) {
            uf.union(getUFIndex(row, col), getUFIndex(surroundRow, surroundCol));
            ufPer.union(getUFIndex(row, col), getUFIndex(surroundRow, surroundCol));
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkPoseThrow(row, col);
        if (!sites[row - 1][col - 1]) {
            sites[row - 1][col - 1] = true;
            openSites++;

            connectSite(row, col, -1, 0);
            connectSite(row, col, 1, 0);
            connectSite(row, col, 0, -1);
            connectSite(row, col, 0, 1);

            if (row == 1) {
                uf.union(getUFIndex(row, col), ufTopIndex);
                ufPer.union(getUFIndex(row, col), ufTopIndex);
            }
            if (row == size) {
                ufPer.union(getUFIndex(row, col), ufBottomIndex);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkPoseThrow(row, col);
        return sites[row - 1][col - 1];
    }

    // is the site (row, col) full?
    // A full site is an open site that can be connected
    // to an open site in the top row via a chain of neighboring
    // (left, right, up, down) open sites.
    public boolean isFull(int row, int col) {
        checkPoseThrow(row, col);
        return isOpen(row, col) && (uf.find(getUFIndex(row, col)) == uf.find(ufTopIndex));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
       return ufPer.find(ufTopIndex) == ufPer.find(ufBottomIndex);
    }

    // test client (optional)
    public static void main(String[] args) {
        StdOut.println("man now is the fake code!");
    }
}
