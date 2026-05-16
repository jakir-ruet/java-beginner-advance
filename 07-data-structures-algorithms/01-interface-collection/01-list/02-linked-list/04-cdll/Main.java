// Node class
class Node {
    String song;
    Node next;
    Node prev;

    public Node(String song) {
        this.song = song;
        this.next = null;
        this.prev = null;
    }
}

// Circular Doubly Linked List Playlist
class CircularDoublyLinkedList {

	Node head = null;
	Node tail = null;
	Node current = null;

	// Add song
	public void add(String song) {
		Node newNode = new Node(song);

		if (head == null) {
			head = newNode;
			tail = newNode;

			head.next = head;
			head.prev = head;

			current = head;
		} else {
			tail.next = newNode;
			newNode.prev = tail;

			newNode.next = head;
			head.prev = newNode;

			tail = newNode;

			// maintain circular links
			tail.next = head;
			head.prev = tail;
		}
	}

	// Display playlist
	public void display() {

		if (head == null) {
			System.out.println("Playlist is empty.");
			return;
		}

		Node temp = head;

		System.out.println("\n--- Playlist ---");

		do {
			if (temp == current) {
				System.out.println(">>> " + temp.song + " <<<");
			} else {
				System.out.println(temp.song);
			}

			temp = temp.next;

		} while (temp != head);
	}

	// Play next song
	public void playNext() {

		if (current == null) {
			System.out.println("Playlist is empty.");
			return;
		}

		current = current.next;

		System.out.println("\n▶ Now Playing Next: " + current.song);
	}

	// Play previous song
	public void playPrevious() {

		if (current == null) {
			System.out.println("Playlist is empty.");
			return;
		}

		current = current.prev;

		System.out.println("\n◀ Now Playing Previous: " + current.song);
	}
}
public class Main {

    public static void main(String[] args) {

        CircularDoublyLinkedList playlist = new CircularDoublyLinkedList();

        // Add songs
        playlist.add("Shape of You");
        playlist.add("Faded");
        playlist.add("Perfect");
        playlist.add("Believer");
        playlist.add("Love Yourself");

        // Initial state
        playlist.display();

        // Navigate forward
        playlist.playNext();
        playlist.display();

        playlist.playNext();
        playlist.display();

        // Navigate backward
        playlist.playPrevious();
        playlist.display();

        playlist.playPrevious();
        playlist.display();
    }
}
