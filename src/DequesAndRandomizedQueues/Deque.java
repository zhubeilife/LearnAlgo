/*
    4st-not need the first.next = last, last.previous = first.
    just set the same one
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int n;

    private class Node {
        private Item item;
        private Node next;
        private Node previous;
    }

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        n = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("man, carefully!");

        Node oldfist = first;
        // TODO give a constructor?
        // then I can give default next = null
        first = new Node();
        first.item = item;

        if (n == 0) {
            last = first;
        }
        else {
            first.next = oldfist;
            oldfist.previous = first;
        }
        n++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("man, carefully!");

        Node oldlast = last;
        last = new Node();
        last.item = item;

        if (n == 0) {
            first = last;
        }
        else {
            oldlast.next = last;
            last.previous = oldlast;
        }
        n++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("man, come on");

        Node oldfirst = first;

        if (n == 1) {
            first = null;
            last = null;
        }
        else {
            first = oldfirst.next;
            first.previous = null;
        }
        // TODO do need to set it to null to let garbage collection works?
        n--;
        return oldfirst.item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("man, come on");

        Node oldlast = last;

        if (n == 1) {
            first = null;
            last = null;
        }
        else {
            last = oldlast.previous;
            last.next = null;
        }

        n--;
        return oldlast.item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("ops");
            // maybe here can simply
            Node oldcurrent = current;
            current = oldcurrent.next;
            return oldcurrent.item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();

        // Test as normal queude
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) deque.addLast(item);
            else if (!deque.isEmpty()) StdOut.print(deque.removeFirst() + " ");
        }
        StdOut.println("(" + deque.size() + " left on deque)");
    }
}
