// Define Node class for circular linked list
class Node {
    String song;
    Node next;

    public Node(String song) {
        this.song = song;
        this.next = null;
    }
}

class CircularLinkedList {

    Node head = null;
    Node tail = null;

    // Current playing song
    Node currentSong = null;

    // Add song
    public void addSong(String song) {

        Node newNode = new Node(song);

        if (head == null) {
            head = newNode;
            tail = newNode;

            tail.next = head;

            currentSong = head;
        }
        else {
            tail.next = newNode;
            tail = newNode;

            tail.next = head;
        }
    }

    // Display playlist
    public void displayPlaylist() {

        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        Node temp = head;

        do {

            if (temp == currentSong) {
                System.out.println(">>> " + temp.song + " <<<");
            }
            else {
                System.out.println(temp.song);
            }

            temp = temp.next;

        } while (temp != head);
    }

    // Play next song
    public void playNext() {

        if (currentSong == null) {
            return;
        }

        currentSong = currentSong.next;

        System.out.println("\nNow Playing Next:");
        displayPlaylist();
    }

    // Play previous song
    public void playPrevious() {

        if (currentSong == null) {
            return;
        }

        Node temp = head;

        // Find previous node
        while (temp.next != currentSong) {
            temp = temp.next;
        }

        currentSong = temp;

        System.out.println("\nNow Playing Previous:");
        displayPlaylist();
    }
}

public class Main {

    public static void main(String[] args) {

        CircularLinkedList playlist = new CircularLinkedList();

        playlist.addSong("Shape of You");
        playlist.addSong("Faded");
        playlist.addSong("Perfect");
        playlist.addSong("Believer");

        System.out.println("Initial Playlist:");
        playlist.displayPlaylist();

        playlist.playNext();

        playlist.playNext();

        playlist.playPrevious();
    }
}
