import java.util.*;
import java.awt.Graphics;

/**
 * This class is a specialized Linked List of Points that represents a
 * Tour of locations attempting to solve the Traveling Salesperson Problem
 * 
 * @author
 * @version
 */

public class Tour implements TourInterface
{
    // instance variables
    private ListNode root;
    private int size;

    // constructor
    public Tour()
    {
        root = null;
        size = 0;
    }

    //return the number of points (nodes) in the list   
    public int size()
    {
        return size;
    }

    // append Point p to the end of the list
    public void add(Point p)
    {
        ListNode newNode = new ListNode(p);
        ListNode current = root;
        if(root == null){
            root = newNode;
        }
        else{
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    } 

    // print every node in the list 
    public void print()
    {   
        ListNode current = root;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
    // draw the tour using the given graphics context
    public void draw(Graphics g)
    {
        ListNode current = root;
        while(current != null){
            g.fillOval((int)current.data.x, (int)current.data.y, 4, 4);
            current = current.next;
        }
        current = root;
        ListNode temp = root;
        while(current.next != null){
            g.drawLine((int)current.data.x, (int)current.data.y, (int)current.next.data.x, (int)current.next.data.y);
            current = current.next;
            //           temp = temp.next;
        }
        g.drawLine((int)(temp.data.x), (int)(temp.data.y), (int)(current.data.x), (int)(current.data.y));
    }

    //calculate the distance of the Tour, but summing up the distance between adjacent points
    //NOTE p.distance(p2) gives the distance where p and p2 are of type Point
    public double distance()
    {
        double distance = 0;
        ListNode current = root;
        while(current.next != null){ // adds the distance of the current point and traverses the list
            distance += current.data.distance(current.next.data);
            current = current.next;
        }
        distance += root.data.distance(current.data);
        return distance;
    }

    // add Point p to the list according to the NearestNeighbor heuristic
    public void insertNearest(Point p)
    {
        ListNode point = new ListNode(p);
        if(root == null) //if list is empty, it makes the point the beginning of the list
        {
            root = point;
        }
        else
        {
            ListNode current = root;
            ListNode current2 = root;
            double minDistance = Double.MAX_VALUE;
            int i = 0;
            int indexOfMin = -1;
            while(current != null) // loops through the list until the end of it
            {
                double value = p.distance(current.data.x, current.data.y);
                if(minDistance > value){ //sets the minimum distance if the current one is smaller
                    minDistance = value;
                    indexOfMin = i;
                }
                current = current.next;
                i++;
            }
            current = root;
            for(int j = 0; j < indexOfMin ; j++) //loops through the list to get to the end
            {
                current = current.next;
            }
            ListNode x = current.next;
            current.next = point;
            point.next = x;
        }
        size++;
    }
   
    // add Point p to the list according to the InsertSmallest heuristic
    public void insertSmallest(Point p)
    {         
        if(size == 0) //if the list is empty it inserts the point at the root
        {
            root = new ListNode(p);
            size++;
        }
        else
        {
            ListNode n = root;
            int nearIndex = 0;
            int count = 0;
            double minDist = Integer.MAX_VALUE;
            double original = distance();
            while(n.next != null)//loops through comparing the total distance if point was added at each index. tracks the minimum total distance and the index at which it was found at
            {
                n.next = new ListNode(p, n.next);
                double dist = original - n.data.distance(n.next.next.data) + n.data.distance(n.next.data) + n.next.data.distance(n.next.next.data);
                if(dist < minDist)
                {
                    minDist = dist;
                    nearIndex = count;
                }
                n.next = n.next.next;
                n = n.next;
                count++;
            }
            n.next = new ListNode(p, n.next);
            double dist = distance();
            if(dist < minDist)//compares the total distance between the last Node in the ListNode to the Point p with the minimum total distance. Updates nearIndex if less.
            {
                minDist = dist;
                nearIndex = count;
            }
            n.next = n.next.next;
            ListNode m = root;
            for(int i = 0; i < nearIndex; i++)// loops through to the Node the point needs to be linked to
            {
                m = m.next;
            }
            m.next = new ListNode(p, m.next);
            size++;
        }
    }

    // This is a private inner class, which is a separate class within a class.

    public class ListNode{
        private Point data;
        private ListNode next;

        public ListNode(Point p, ListNode n)
        {
            this.data = p;
            this.next = n;
        }

        public ListNode(Point p)
        {
            this(p, null);
        }        
    }
}