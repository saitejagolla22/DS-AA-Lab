// linked list--- creation
// insertion
// deletion 
// searching
// reverse
// sort
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
    
    //reverse
    void reverse() {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;   // store next
            current.next = prev;   // reverse link
            prev = current;        // move prev forward
            current = next;        // move current forward
        }
        head = prev;               // new head
    }
    
    //sort
    void sort() {
        if (head == null) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    // swap data
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
    
    // Remove duplicates from a sorted list
    void removeDuplicates() {
        if (head == null) return;

        Node current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                // Skip the duplicate node
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
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
        System.out.println("Inserting Data Elements:");
        list.insertAtEnd(90);
        list.printList();
        list.insertAtBeginning(20);
        list.printList();
        list.insertAtEnd(30);
        list.printList();
        list.insertAtBeginning(40);
        list.printList();
        System.out.println("Insertion at Position:");
        list.insertAtPosition(2, 90);
        list.printList();
        list.insertAtPosition(1, 25);
        list.printList(); 
        
        // Deletions
        System.out.println("Deletions Data Elements:");
        list.deleteAtBeginning(); 
        list.printList();
        list.deleteAtEnd(); 
        list.printList(); 
        System.out.println("Deletion Data at Position:");
        list.deleteAtPosition(1); 
        list.printList(); 
       
        // Search operation
        System.out.println("Searching Opertion:");
        int pos = list.search(20); // Should be 0
        if (pos != -1)
            System.out.println("Element found at position: " + pos);
        else
            System.out.println("Element not found");
        System.out.println("Final list After insertion and deletion operaions:");
        list.printList();
        //Reversing operation
        System.out.println("Reversing Data Elements:");
        list.reverse();
        list.printList();
        
        //Sorting operation
        System.out.println("Sorting Data Elements:");
        list.sort();
        list.printList();
        
        //Removing duplicates in the list
        System.out.println("Removing duplicates data elements:");
        list.removeDuplicates();
        list.printList();
    }
}
