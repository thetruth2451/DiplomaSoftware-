import java.util.LinkedList;

public class DoublyLinkedList
{

    //Double linked list class contains linked list combined with other features below
    //The linked list within this class creates a double linked list
    public LinkedList<Node> doublelinkedList = new LinkedList<Node>();
    //Initially, head and tail is set to null
    public Node head;
    public Node tail;

    class Node
    {
        public Node previous;
        public Node next;

        //Each node contains a city and country
        public Country country;
        public Country.City city;
        public Node(Country country, Country.City city)
        {
            this.country = country;
            this.city = city;
        }

    }

    //add a node to the list
    public void addNode(Country country, Country.City city)
    {
        //Create a new node
        Node newNode = new Node(country,city);
        //if list is empty, head and tail points to newNode
        if (head == null)
        {
            head = tail = newNode;
            //head's previous will be null
            head.previous = null;
            //tail's next will be null
            tail.next = null;
        }
        else
        {
            //add newNode to the end of list. tail->next set to newNode
            tail.next = newNode;
            //newNode->previous set to tail
            newNode.previous = tail;
            //newNode becomes new tail
            tail = newNode;
            //tail's next point to null
            tail.next = null;
        }
        doublelinkedList.addLast(newNode);

    }
    public void printNodes()
    {
        //Node current will point to head
        Node current = head;
        if(head == null)
        {
            System.out.println("Doubly linked list is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while(current != null)
        {
            //Print each node and then go to next.
            System.out.println("Country is: " + current.country.returnCountry() + " ");
            System.out.println("City of country is: " + current.city.returnCity() + " ");
            System.out.println("");
            current = current.next;
        }
    }
}
