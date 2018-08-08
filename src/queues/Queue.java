package queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  Objects of type Queue manage items in a singly linked list where we can enqueue()
 *  from the front and dequeue() items from the end of the queue.
 *
 *  @author Foothill College, Veronika Cabalova Joseph
 */

public class Queue <T> implements Iterable <T>
{

    //*************************** Inner Class NODE START **************************
    /**
     * inner class Node describes single Node object of singly linked Queue
     */
    private class Node
    {
        Node next;
        T data;

        /**
         * Constructor of inner class initializes data and next
         */
        Node(T dataItem)
        {
            data = dataItem;
            next = null;
        }

        /**
         * this method gets next node
         * @return next node
         */
        public Node getNext()
        {
            return this.next;
        }


//        public String toString()
//        {
//            return data.toString();
//        }
    }
    //**************************** Inner Class NODE END ****************************


    //use this for testing and debugging purposes
    private String name;
    //points to the front of the queue
    private Node head;
    //points to the end of the queue
    private Node tail;
    //size of queue
    private int size;

    /**
     * constructor that takes in a user assigned name and initializes the class attributes
     * @param userAssignedName string from user
     */
    Queue(String userAssignedName)
    {
        name = userAssignedName;
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * method that checks size of queue
     * @return size of queue
     */
    public int size()
    {
        return size;
    }

    /**
     * method that checks if queue is empty
     * @return true if queue is empty
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * this method prints the list of songs and all of the song details
     * @return formatted string of songs
     */
    public String toString()
    {
        //java unicode for music note icon
        String note = "\u266A ";

        String queueString = "";

        Iterator<T> iterator = iterator();

        while (iterator.hasNext())
        {
            queueString += note  + iterator.next() + ";\n";
        }

        return  this.name + " has " + this.size
                + " songs: \n\n"
                + queueString ;
    }

    /**
     * takes a generic item as an argument and adds the item to the end of the queue
     * @param "T" generic item
     */
    public void enqueue(T itemToAdd)
    {
        Node addNode = new Node(itemToAdd);

        //won't add null object to queue
        if(itemToAdd == null)
        {
            return;
        }
        //if queue is empty, head and tail point to newly added item
        if(head == null && tail == null)
        {
            head = addNode;
            tail = addNode;
        }
        else
        {
            //adding item thorough tail
            tail.next = addNode;
            tail = addNode;
        }
        size++;
    }

    /**
     * receives no arguments and removes the item from the front of the queue
     * @return generic dequeue-ed item
     */
    public T dequeue()
    {
        if(isEmpty())
        {
            throw new NoSuchElementException();
        }

        T data = head.data;

        if(head == null)
        {
            tail = null;
        }

        this.head = head.next;
        this.size--;
        return data;
    }

    /**
     * this method looks at the least recently added item in the queue and returns
     * an object of the generic type for the data seen at the front of the queue.
     * @return generic type for data at the top of the queue
     */
    public T peek()
    {
        //if queue is empty, returns null
        if (isEmpty())
        {
            return null;
        }
        return head.data;
    }

    /**
     * this method gets name
     * @return String name
     */
    public String getName()
    {
        return name;
    }

    /**
     * method that calls for inner QueueIterator class
     * @return queue iterator item
     */
    public Iterator<T> iterator()
    {
        return new QueueIterator();
    }


    //********************* Inner Class QueueIterator START ************************
    /**
     * inner class QueueIterator is parameterized class which implements an the Iterator interface.
     * This class provides an iterator over the outer generic Queue.
     */
    private class QueueIterator implements Iterator<T>
    {
        private Node currentNode;

        /**
         * constructor, default access for package only
         */
        QueueIterator()
        {
            this.currentNode = head;
        }

        /**
         * method that checks if the iteration has more elements
         * @return boolean true value if there is an element, false if there isn't
         */
        public boolean hasNext()
        {
            return currentNode != null;
        }

        /**
         * method checks if iterator has more elements
         * @return returns element from the iterator, moves iterator up one
         */
        public T next()
        {
            if(!hasNext())
            {
                throw new NoSuchElementException();
            }
            T tempNode = currentNode.data;
            currentNode = currentNode.next;

            return tempNode;
        }
    }
    //********************* Inner Class QueueIterator END ************************
}