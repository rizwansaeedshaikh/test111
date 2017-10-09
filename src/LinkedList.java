
public class LinkedList
{

    public LinkedList()
    {
        super();
    }
    
    private Node head;
    private int size;

    public void display()
    {

        Node current = head;
        while (current != null)
        {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void add(Node node)
    {

        if(this.head == null) {
            this.head = node;
            return;
        }
        
        Node current = head;
        while (current.next != null)
        {

            current = current.next;
        }
        current.next  = node;
    }
    
    public void reverse() {
        
        /*Node prev = this.head;
        Node current = this.head.next;
        //Node next = current.next;
        Node next = null;
        
        while(current != null) {
            
            current.next = prev;
            prev = current;
            next = current.next;
            current = next;
        }*/
        
        Node current = this.head;
        Node prev = null;
        Node next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head = prev;
    }

    public static void main(String[] args)
    {

        LinkedList list = new LinkedList();
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(3));
        list.display();
        list.reverse();
        list.display();
    }

    private static class Node
    {

        private int data;
        private Node next;

        Node(int data)
        {
            this.data = data;
        }

        Node()
        {
            super();
        }

    }
}
