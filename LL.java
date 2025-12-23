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
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    // Insert at HEAD
    void insertAtHead(int data) {
        Node temp = new Node(data);

        if (head == null) {
            head = temp;
            tail = temp;
            return;
        }

        temp.next = head;
        head = temp;
    }

    // Insert at END
    void insertAtEnd(int data) {
        Node temp = new Node(data);

        if (head == null) {
            head = temp;
            tail = temp;
            return;
        }

        tail.next = temp;
        tail = temp;
    }

    // your insert function = insert at end
    void insert(int data) {
        insertAtEnd(data);
    }

    // Insert at a given POSITION (1-based index)
    void insertAtPosition(int pos, int data) 
    {

    // insert at head
    if (pos == 1) {
        insertAtHead(data);
        return;
    }

    Node newNode = new Node(data);
    Node temp = head;
    int count = 1;

    // move to position - 1
    while (count < pos - 1 && temp != null) {
        temp = temp.next;
        count++;
    }

    // invalid position (beyond length + 1)
    if (temp == null) {
        System.out.println("Invalid position");
        return;
    }

    // inserting after last node → insert at end
    if (temp == tail) {
        insertAtEnd(data);
        return;
    }

    // normal middle insert
    newNode.next = temp.next;
    temp.next = newNode;
}

    // DELETE node at a given position
   void deleteNode(int pos) {
    if (head == null) return;

    // delete HEAD
    if (pos == 1) {
        Node temp = head;
        head = head.next;

        // if list becomes empty
        if (head == null) 
            tail = null;

        temp.next = null; // good cleanup (optional in Java)
        return;
    }

    Node prev = null;
    Node curr = head;
    int count = 1;

    // move to the position
    while (count < pos && curr != null) {
        prev = curr;
        curr = curr.next;
        count++;
    }

    // invalid position
    if (curr == null) return;

    // if deleting last node
    if (curr == tail) {
        tail = prev;
    }

    prev.next = curr.next;
    curr.next = null; // cleanup (optional)
}

    // DISPLAY the list
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // COUNT length
    int countLength() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    // SEARCH a value
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

        System.out.println("Element " + key + " not found in the list.");
    }
}

public class LL { // red mark refer to main class 
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

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
        System.out.println( list.countLength());
        list.search(20);
    }
}
