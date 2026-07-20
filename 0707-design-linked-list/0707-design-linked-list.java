class MyLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public MyLinkedList() {
        head = null;
    }

    public int get(int index) {

        Node currNode = head;
        int i = 0;

        while (currNode != null && i < index) {
            currNode = currNode.next;
            i++;
        }

        if (currNode == null) {
            return -1;
        }

        return currNode.data;
    }

    public void addAtHead(int val) {

        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addAtTail(int val) {

        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;

        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    public void addAtIndex(int index, int val) {

        if (index == 0) {
            addAtHead(val);
            return;
        }

        Node currNode = head;
        int i = 0;

        while (currNode != null && i < index - 1) {
            currNode = currNode.next;
            i++;
        }

        if (currNode == null) {
            return;
        }

        Node newNode = new Node(val);

        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    public void deleteAtIndex(int index) {

        if (head == null) {
            return;
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        Node currNode = head;
        int i = 0;

        while (currNode.next != null && i < index - 1) {
            currNode = currNode.next;
            i++;
        }

        if (currNode.next == null) {
            return;
        }

        currNode.next = currNode.next.next;
    }
}