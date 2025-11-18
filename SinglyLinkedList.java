class SinglyLinkedList {
    // Node structure
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    Node head;

    // Insertion at the beginning
    public void insertAtBeginning(int new_data) {
        Node newNode = new Node(new_data);
        newNode.next = head;
        head = newNode;
    }

    // Insertion at the end
    public void insertAtEnd(int new_data) {
        Node newNode = new Node(new_data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null)
            last = last.next;
        last.next = newNode;
    }

    // Insertion at a specific position (0-based index)
    public void insertAtPosition(int position, int new_data) {
        Node newNode = new Node(new_data);
        if (position == 0) {
            insertAtBeginning(new_data);
            return;
        }
        Node temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) return; // Invalid position
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Deletion at the beginning
    public void deleteAtBeginning() {
        if (head == null) return;
        head = head.next;
    }

    // Deletion at the end
    public void deleteAtEnd() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null)
            temp = temp.next;
        temp.next = null;
    }

    // Deletion at a specific position (0-based index)
    public void deleteAtPosition(int position) {
        if (head == null) return;
        if (position == 0) {
            deleteAtBeginning();
            return;
        }
        Node temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) return; // Invalid position
        temp.next = temp.next.next;
    }

    // Search for an element, returns position or -1 if not found
    public int search(int key) {
        Node current = head;
        int position = 0;
        while (current != null) {
            if (current.data == key)
                return position;
            current = current.next;
            position++;
        }
        return -1;
    }

    // Display the list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Driver code to test the implementation
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Insertions
        list.insertAtEnd(10);
        list.insertAtBeginning(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(40);
        list.insertAtPosition(1, 25); // Insert 25 at position 1
        list.printList(); // Expected: 20 25 10 30

        // Deletions
        list.deleteAtBeginning(); // Removes 20
        //System.out.println("list= ");
        list.printList(); // Expected: 25 10 30
        list.deleteAtEnd(); // Removes 30
        list.printList(); // Expected: 25 10
        list.deleteAtPosition(1); // Removes 10 (position 1)
        list.printList(); // Expected: 25

        // Search operation
        int pos = list.search(10); // Should be 0
        if (pos != -1)
            System.out.println("Element found at position: " + pos);
        else
            System.out.println("Element not found");
    }
}
