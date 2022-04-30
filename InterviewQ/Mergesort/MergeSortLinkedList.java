import java.util.Iterator;
/**
 * 对单向链表的由小到大归并排序
 * @author evasean www.cnblogs.com/evasean/
 * @param <T>
 */
public class MergeSortLinkedList <T extends Comparable<T>> implements Iterable<T>{
    private Node first = null;
    private Node last = null;
    private int n;
    private class Node{
        T element;
        Node next;
    }
    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new ListIterator();
    }
    private class ListIterator implements Iterator<T>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current != null;
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            T t = current.element;
            current = current.next;
            return t;
        }
    }
    public void add(T t){
        Node node = new Node();
        node.element = t;
        node.next = null;
        if(first == null && last == null){
            first = node;
            last = node;
        }else if(first != null && first == last){
            first.next = node;
            last = node;
        }else{
            last.next = node;
            last = node;
        }
        n++;
    }
    @Override
    public String toString(){
        Iterator<T> iter = iterator();
        String ret = iter.next().toString();
        while(iter.hasNext()){
            ret += ", "+ iter.next().toString() ;
        }
        return ret;
    }
    public void mergeSort(){
        first = sort(first);
    }

    private Node sort(Node head){
        if(head == null || head.next == null) return head;
        Node slow = head;
        Node fast = head;
        //取中间节点
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node left = head;
        Node right = slow.next;
        slow.next = null; //将左右链表分开
        left = sort(left);
        right = sort(right);
        return merge(left,right);
    }
    private Node merge(Node left, Node right){
        //System.out.println("left="+left.element+",right="+right.element);
        Node aux = new Node(); //需要耗费logn的额外空间
        Node l= left;
        Node r = right;
        Node current = aux;
        while(l != null && r!=null){
            if(less(r.element,l.element)) {
                current.next = r;
                current = current.next;
                r = r.next;
            }
            else {
                current.next = l;
                current = current.next;
                l= l.next;
            }
        }
        if(l!=null) current.next = l; // 如果左侧没遍历完，将其连接至current后
        else if(r != null) current.next = r; //如果右侧没遍历完，将其连接至current后
        return aux.next; //返回归并好的链表
    }
    public static void main(String[] args){
        ShuffleLinkedList<Integer> sll = new ShuffleLinkedList<Integer>();
        sll.add(1);
        sll.add(2);
        sll.add(11);
        sll.add(9);
        sll.add(10);
        sll.add(4);
        sll.add(7);
        System.out.println(sll);
        sll.mergeSort();
        System.out.println(sll);
    }

}