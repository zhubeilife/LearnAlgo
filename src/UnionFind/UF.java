/******************************************************************************
 *  Compilation:  javac UF.java
 *  Execution:    java UF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/15uf/tinyUF.txt
 *                https://algs4.cs.princeton.edu/15uf/mediumUF.txt
 *                https://algs4.cs.princeton.edu/15uf/largeUF.txt
 *
 *  Weighted quick-union by rank with path compression by halving.
 *
 *  % java UF < tinyUF.txt
 *  4 3
 *  3 8
 *  6 5
 *  9 4
 *  2 1
 *  5 0
 *  7 2
 *  6 1
 *  2 components
 *
 * History
 *      20210113 First implements
 ******************************************************************************/

import java.util.Vector;

public class UF {

    private int[] data;

    /**
     * initialize union-find data structure with N objects
     * @param n the numbers of elements
     */
    public UF(int n) {
        data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }
    }

    /**
     * add connection between p and q
     * @param p
     * @param q
     */
    public void union(int p, int q) {
       if (data[p] == data[q]) return;
       if (data[p] > data[q]) {
           dounion(q, p);
       }
       else {
           dounion(p, q);
       }
    }

    private void dounion(int p, int q) {
        int pData = data[p];
        for (int i = 0; i < data.length; i++) {
            if (data[i] == pData) {
                data[i] = q;
            }
        }
    }

    /**
     * check p and q in the same component
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return data[p] == data[q];
    }

    /**
     * component identifier for p
     * @param p
     * @return
     */
    public int find(int p) {
        return data[p];
    }

    /**
     * number of components
     * @return
     */
    public int count() {
        Vector<Integer> v = new Vector<Integer>(0);
        for (int datum : data) {
            if (!v.contains(datum)) {
                v.add(datum);
            }
        }
        return v.size();
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        UF uf = new UF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components ");
    }
}