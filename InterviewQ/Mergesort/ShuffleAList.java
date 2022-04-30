/**
 * This is in fact a question about shuffle sort. First of all, what does shuffle even mean?
 * Well, it means generate a uniformly random permutation of the original array.
 * To do that, there are two ways:
 * 1. Shuffle sort: we generate a random number (uniformly distributed) for each entry in the array. 
 *    We sort the array according to the value of the random number.
 * 
 * 2. Knuth shuffle: In iteration i, pick an integer r between 0 and i uniformly at random. Swap a[i] and a[r]. 
 *    Proof?
 */ 
 
/**
 * public class Node{
 *     Node next;
 *     int val;
 * }
 */
import java.util.Random;
import java.util.Arrays;
public class ShuffleAList{
    private class Pair implements Comparable{
        double num;
        int val;
        
        public int compareTo(Pair b){
            if(this.num < b.num) return  -1;
            if(this.num == b.num) return 0;
            if(this.num > b.num) return 1;
        }
    }
    
    public void shuffleList(Node head){
        if(head == null) return;
        // first get the number of nodes in the list
        Node current = head;
        int total = 0;
        while(current != null){
            total++;
            current = current.next;
        }
        
        Pair[] pairs = new Pair[total];
        
        current = head;
        int i = 0;
        Pair p = null;
        Random rand = new Random();
        while(current != null){
            p = new Pair();
            p.num = rand.nextDouble();
            p.val = current.val;
            pairs[i++] = p;
            current = current.next;
        }
        
        Arrays.sort(pairs); // the comparison will be based on the value of the num in a Pair
        
        current = head;
        i = 0;
        while(current != null){
            current.val = pairs[i++].val;
            current = current.next;
        }
    }
    
    public void shuffleListKnuth(Node head){
        if(head == null) return;
        // first get the number of nodes in the list
        Node current = head;
        int total = 0;
        while(current != null){
            total++;
            current = current.next;
        }
        
        int[] vals = new int[total];
        int i = 0;
        current = head;
        while(current != null){
            vals[i++] = current.val;
            current = current.next;
        }
        
        Random rand = new Random();
        int selected = 0;
        int temp;
        for(i = 0; i < total; i++){
            selected = rand.nextInt(i+1); // we use i+1 since nextInt is exclusive on the right hand side
            // swap the value;
            temp = vals[selected];
            vals[selected] = vals[i];
            vals[i] = temp;
        }
        
        // change the list
        current = head;
        i = 0;
        while(current != null){
            current.val = vals[i++];
            current = current.next;
        }
    }
}