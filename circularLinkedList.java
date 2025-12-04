import java.util.Scanner;

class CircularLinkedList {

    // Node class
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node last = null;   // last node of circular list

    // Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (last == null) { // list empty
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
        }
    }

    // Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }

    // Insert at specific position (1-based index)
    public void insertAtPosition(int data, int position) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = last.next;
        int count = 1;

        while (count < position - 1 && temp != last) {
            temp = temp.next;
            count++;
        }

        if (count != position - 1 && temp == last) {
            System.out.println("Position out of bounds!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if (temp == last) {
            last = newNode;
        }
    }

    // Delete a node by value
    public void deleteNode(int key) {
        if (last == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = last.next;
        Node prev = last;

        // Search for node
        do {
            if (current.data == key) {
                if (current == last && current == last.next) {
                    last = null; // only one element
                } else {
                    prev.next = current.next;
                    if (current == last) {
                        last = prev;
                    }
                }
                System.out.println("Node deleted: " + key);
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);

        System.out.println("Node not found!");
    }

    // Search for a value
    public boolean search(int key) {
        if (last == null) return false;

        Node temp = last.next;
        do {
            if (temp.data == key) return true;
            temp = temp.next;
        } while (temp != last.next);

        return false;
    }

    // Display list
    public void display() {
        if (last == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = last.next;
        System.out.print("Circular Linked List: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != last.next);
        System.out.println();
    }
}


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();

        while (true) {
            System.out.println("\n=== Circular Linked List Operations ===");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete Node");
            System.out.println("5. Search");
            System.out.println("6. Display");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    list.insertAtBeginning(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    list.insertAtEnd(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    list.insertAtPosition(val, pos);
                    break;

                case 4:
                    System.out.print("Enter value to delete: ");
                    list.deleteNode(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter value to search: ");
                    System.out.println(list.search(sc.nextInt()) ? "Found" : "Not Found");
                    break;

                case 6:
                    list.display();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
