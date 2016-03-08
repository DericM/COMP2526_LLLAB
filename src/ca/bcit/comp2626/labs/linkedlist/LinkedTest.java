package ca.bcit.comp2626.labs.linkedlist;

/**
 * Iterator interface defines two methods, hasNext() and next().
 * 
 * @author BCIT
 * @version 1.0
 */
interface Iterator {

    /**
     * @return true if there is another element.
     */
    boolean hasNext();

    /**
     * @return the next int.
     */
    int next();
}

/**
 * LinkedList is a data structure which contains Nodes.
 * 
 * @author BCIT
 * @version 1.0
 */
class LinkedList {

    Node head;

    /**
     * Node defines the data structure used in the LinkedList.
     * 
     * @author BCIT
     * @version 1.0
     */
    class Node {

        int data;
        Node next;

        /**
         * Constructor for objects of type Node.
         * 
         * @param datum
         *            the datum, an int
         */
        public Node(int datum) {
            data = datum;
        }
    }

    /**
     * Adds the specified datum to the front of the LinkedList.
     * 
     * @param datum
     *            an int.
     */
    public void addToFront(int datum) {
        Node n = new Node(datum);
        if(head == null) {
            head = n;
        }
        else {
            n.next = head;
            head = n;
        }
            
        
    }

    /**
     * Adds the specified datum to the end of the LinkedList.
     * 
     * @param datum
     *            an int.
     */
    public void addToEnd(int datum) {
        Node n = new Node(datum);
        Node h = head;
        if(head == null) {
            head = n;
        }
        else {
            while(h.next != null)
                h = h.next;
            h.next = n;
        }
    }

    /**
     * Adds the specified datum to the LinkedList while maintaining the 
     * sorted order of the data in the LinkedList's nodes.
     * 
     * @param datum
     *            an int.
     */
    public void addInOrder(int datum) {
        Node n = new Node(datum);
        Node h = head;
        if(head == null) {
            head = n;
            return;
        }
        if(datum < h.data){
            n.next = head;
            head = n;
            return;
        }
        while(h.next != null){
            if(datum >= h.data && datum < h.next.data) {
                n.next = h.next;
                h.next = n;
                return;
            }
            h = h.next;
        }
        h.next = n;
    } 
    
    
    
    
    
    

    /**
     * @return an Iterator for this LinkedList.
     */
    public Iterator iterator() {

        return new Iterator() {
            Node cur = head;

            /**
             * Returns true if there is another Node for the Iterator to visit.
             * 
             * @return true if there is another Node to visit, else false
             */
            public boolean hasNext() {
                return cur != null;
            }

            /**
             * Returns the next Node's datum.
             * 
             * @return the next Node's datum, as an int.
             */
            public int next() {
                Node temp = cur;
                cur = cur.next;
                return temp.data;
            }
        };
    }
}

/**
 * LinkedTest.
 * 
 * @author BCIT
 * @version 1.0
 */
public class LinkedTest {

    /**
     * Prints the specified LinkedList by iterating through it.
     * 
     * @param listToPrint
     *            the LinkedList to print
     */
    public static void print(LinkedList listToPrint) {
        Iterator iterator = listToPrint.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * Drives the program.
     * 
     * @param args
     *            Command line arguments.
     */
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        int[] data = { 1, 2, 3, 4, 5 };
        for (int i = 0; i < data.length; i++) {
            list.addToFront(data[i]);
        }
        print(list);
        System.out.println("===========================");

        LinkedList list2 = new LinkedList();
        int[] data2 = { 2, 4, 6, 8, 10, 12 };
        for (int j = 0; j < data2.length; j++) {
            list2.addToEnd(data2[j]);
        }
        print(list2);
        System.out.println("===========================");

        LinkedList list3 = new LinkedList();
        int[] data3 = { 3, 13, 11, 5, 7, 1, 9 };
        for (int k = 0; k < data3.length; k++) {
            list3.addInOrder(data3[k]);
        }
        print(list3);
    }
}