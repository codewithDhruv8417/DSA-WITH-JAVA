class Node {
    int data;
    Node next;
    Node prev;  // NEW for DLL

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // INSERT AT HEAD
    void insertAtHead(int data) {
        Node temp = new Node(data);

        if (head == null) {
            head = tail = temp;
            return;
        }

        temp.next = head;
        head.prev = temp;
        head = temp;
    }

    // INSERT AT END
    void insertAtEnd(int data) {
        Node temp = new Node(data);

        if (head == null) {
            head = tail = temp;
            return;
        }

        tail.next = temp;
        temp.prev = tail;
        tail = temp;
    }

    // Your insert function = insert at END
    void insert(int data) {
        insertAtEnd(data);
    }

    // INSERT AT POSITION (1-based)
    void insertAtPosition(int pos, int data) {

        if (pos == 1) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int count = 1;

        // Move to pos-1
        while (count < pos - 1 && temp != null) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        if (temp == tail) {
            insertAtEnd(data);
            return;
        }

        // Normal middle insert
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // DELETE at a given position
    void deleteNode(int pos) {
        if (head == null) return;

        // Delete HEAD
        if (pos == 1) {
            Node temp = head;
            head = head.next;

            if (head != null)
                head.prev = null;
            else
                tail = null; // list becomes empty

            return;
        }

        Node curr = head;
        int count = 1;

        while (count < pos && curr != null) {
            curr = curr.next;
            count++;
        }

        if (curr == null) return;

        // Deleting the tail
        if (curr == tail) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        // Middle deletion
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    // DISPLAY FORWARD
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // COUNT LENGTH
    int countLength() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    // SEARCH element
    void search(int key) {
        Node temp = head;
        int position = 1;

        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Element " + key + " found at position " + position);
                return;
            }
            temp = temp.next;
            position++;
        }

        System.out.println("Element " + key + " not found.");
    }
}

public class DLL {   // No red mark now, main class name is correct
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // insert at end
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display();

        // insert at head
        list.insertAtHead(5);
        list.display();

        // insert at middle
        list.insertAtPosition(3, 15);
        list.display();

        // delete nodes
        list.deleteNode(3);
        list.deleteNode(1);
        list.display();

        System.out.println(list.countLength());
        list.search(20);
    }
}
