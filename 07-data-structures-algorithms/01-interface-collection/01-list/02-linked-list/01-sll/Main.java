class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {

    Node head;

    // Display linked list
    public void display() {

        Node tmpNode = head;

        while (tmpNode != null) {
            System.out.print(tmpNode.data + " ");
            tmpNode = tmpNode.next;
        }

        System.out.println();
    }

    // Insert at beginning
    public void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        // If list empty
        if (head == null) {
            head = newNode;
            return;
        }

        Node tmpNode = head;

        while (tmpNode.next != null) {
            tmpNode = tmpNode.next;
        }

        tmpNode.next = newNode;
    }

    // Delete node
    public void delete(int value) {

        // Empty list
        if (head == null) {
            return;
        }

        // Delete first node
        if (head.data == value) {
            head = head.next;
            return;
        }

        Node temp = head;

        // Find previous node
        while (temp.next != null &&
               temp.next.data != value) {

            temp = temp.next;
        }

        // Delete node
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Update node value
    public void update(int oldValue, int newValue) {

        Node temp = head;

        while (temp != null) {

            if (temp.data == oldValue) {
                temp.data = newValue;
                return;
            }

            temp = temp.next;
        }
    }
}

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        // Create linked list
        list.insertAtEnd(10);
        list.insertAtEnd(15);
        list.insertAtEnd(20);
        list.insertAtEnd(25);
        list.insertAtEnd(30);

        // Display original list
        System.out.print("Default Linked List: ");
        list.display();

        // Insert at beginning
        list.insertAtBeginning(5);

        System.out.print("After inserting 5 at beginning: ");
        list.display();

        // Insert at end
        list.insertAtEnd(35);

        System.out.print("After inserting 35 at end: ");
        list.display();

        // Delete 15
        list.delete(15);

        System.out.print("After deleting 15: ");
        list.display();

        // Update 25 to 26
        list.update(25, 26);

        System.out.print("After updating 25 to 26: ");
        list.display();
    }
}
