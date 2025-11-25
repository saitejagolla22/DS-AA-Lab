class DoublyLinkedList {

    // Node of doubly linked list
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) {
            data = d;
            prev = null;
            next = null;
        }
    }

    private Node head;
    private Node tail;

    // Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {           // empty list
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (tail == null) {           // empty list
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Delete from beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }

        if (head == tail) {           // only one node
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Delete from end
    public void deleteFromEnd() {
        if (tail == null) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }

        if (head == tail) {           // only one node
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Display backward
    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = tail;
        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // Test the operations
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtBeginning(5);
        dll.insertAtEnd(30);

        dll.displayForward();   // 5 10 20 30
        dll.displayBackward();  // 30 20 10 5

        dll.deleteFromBeginning();
        dll.displayForward();   // 10 20 30

        dll.deleteFromEnd();
        dll.displayForward();   // 10 20
        dll.displayBackward();  // 20 10
    }
}
