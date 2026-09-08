class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;

        public Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private static final int SIZE = 1000000;

    Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {

        Node bucket = buckets[hash(key)];

        // If key doesn't map to a bucket create a new Node and add it to the bucket
        if (bucket == null) {
            bucket = new Node(key, value);
            buckets[hash(key)] = bucket;
            return;
        }

        Node tail = null;
        while (bucket != null) {
            // if key exists simply update the value
            if (bucket.key == key) {
                bucket.value = value;
                return;
            }
            tail = bucket;
            bucket = bucket.next;
        }
        // If key not present in the Node linkedList
        tail.next = new Node(key, value);

    }

    public int get(int key) {
        Node bucket = buckets[hash(key)];

        while (bucket != null) {
            if (bucket.key == key) {
                return bucket.value;
            }
            bucket = bucket.next;
        }

        return -1;

    }

    public void remove(int key) {

        Node head = buckets[hash(key)];

        // key doesn't exists
        if (head == null)
            return;

        if (head.key == key) {
            buckets[hash(key)] = head.next;
            head.next = null; // remove reference and detach the node;
        }

        Node prev = head;
        head = head.next;

        while (head != null) {
            if (head.key == key) {
                prev.next = head.next;
                head.next = null;
                break;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */