public class QuickUnionUF {
    private int[] id;
    private int count;

    public QuickUnionUF(int n) {
        id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        count = n;
    }

    private int root(int n) {
        if (id[n] == n) return n;
        else return root(id[n]);
    }

    public int count() {
        return count;
    }

    public void union(int p, int q) {
        if (root(p) == root(q)) return;
        id[root(p)] = root(q);
        count--;
    }

    public void ShowElements() {
        for (int i : id) {
            StdOut.print(i + " ");
        }
        StdOut.print(" count: " + count);
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            uf.union(p, q);
            StdOut.print("Connect " + p + " " + q + "   ");
            uf.ShowElements();
            StdOut.print('\n');
        }
        StdOut.println("Total count is " + uf.count());
    }
}
