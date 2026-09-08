class MyHashSet {

    class Node{
        int key;
        Node next;
        public Node(int k){
            key = k;
        }
    }

    private static final int SIZE = 1000000;
    private Node[] buckets;

    public MyHashSet() {
        buckets = new Node[SIZE];
    }

    private int hash(int key){
        return key % SIZE;
    }
    
    public void add(int key) {
        Node prev = null;
        Node head = buckets[hash(key)];

        // key is not mapped to a bucket yet.
        if(head == null){
            buckets[hash(key)] = new Node(key);
            return;
        }

        while(head != null){
            // key already present in bucket. Skip add operation
            if(head.key == key){
                return;
            }
            prev = head;
            head = head.next;
        }

        // Add key to the bucket
        prev.next = new Node(key);

    }
    
    public void remove(int key) {
        Node head = buckets[hash(key)];
        Node prev= null;
        
        if(head == null){
            return;
        }

        if(head.key == key){
            buckets[hash(key)] = head.next;
            head.next = null;
            return;
        }

        prev = head;
        while(head != null){
            if(head.key == key){
                prev.next = head.next;
                head.next = null;
                return;
            }
        }

    }
    
    public boolean contains(int key) {
        Node head = buckets[hash(key)];

        while(head != null){
            if(head.key == key){
                return true;
            }

            head = head.next;
        }

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */