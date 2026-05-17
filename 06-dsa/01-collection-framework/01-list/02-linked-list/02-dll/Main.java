class Node {

    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
    }
}

class DoublyLinkedList {

    Node head;

    public void display() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    public void delete(int value) {

        if (head == null) return;

        Node temp = head;

        while (temp != null) {

            if (temp.data == value) {

                if (temp == head) {
                    head = temp.next;
                }

                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }

                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                }

                return;
            }

            temp = temp.next;
        }
    }

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

        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtEnd(40);
        dll.insertAtEnd(50);

        System.out.println("Doubly Linked List:");
        dll.display();

        dll.insertAtBeginning(5);
        System.out.println("After inserting at beginning:");
        dll.display();

        dll.insertAtEnd(60);
        System.out.println("After inserting at end:");
        dll.display();

        dll.delete(30);
        System.out.println("After deleting 30:");
        dll.display();

        dll.update(20, 25);
        System.out.println("After updating 20 to 25:");
        dll.display();
    }
}
