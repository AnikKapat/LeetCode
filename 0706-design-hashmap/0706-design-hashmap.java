class Pair {
    int key;
    int value;
    Pair next;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class MyHashMap {

    private static final int SIZE = 769;
    private Pair[] buckets;

    public MyHashMap() {
        buckets = new Pair[SIZE];
    }

    private int getIndex(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {

        int index = getIndex(key);

        // Bucket is empty
        if (buckets[index] == null) {
            buckets[index] = new Pair(key, value);
            return;
        }

        Pair current = buckets[index];

        // Search through the linked list
        while (true) {

            // Key already exists → update its value
            if (current.key == key) {
                current.value = value;
                return;
            }

            // Reached the end
            if (current.next == null) {
                break;
            }

            current = current.next;
        }

        // Add new pair at the end
        current.next = new Pair(key, value);
    }

    public int get(int key) {

        int index = getIndex(key);
        Pair current = buckets[index];

        while (current != null) {

            if (current.key == key) {
                return current.value;
            }

            current = current.next;
        }

        return -1;
    }

    public void remove(int key) {

        int index = getIndex(key);
        Pair current = buckets[index];

        if (current == null) {
            return;
        }

        // Key is the first Pair in the bucket
        if (current.key == key) {
            buckets[index] = current.next;
            return;
        }

        while (current.next != null) {

            if (current.next.key == key) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }
    }
}