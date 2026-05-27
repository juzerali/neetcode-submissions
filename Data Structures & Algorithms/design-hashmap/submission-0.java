class MyHashMap {
    int FACTOR = 32;
    int BUCKETS = 10000002/FACTOR;

    @SuppressWarnings("unchecked")
    LinkedList<Entry>[] a = (LinkedList<Entry>[]) new LinkedList[BUCKETS];

    public MyHashMap() {
        
    }

    private int getBucket(int key) {
        return key % BUCKETS;
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        if(a[bucket] == null) a[bucket] = new LinkedList<>();

        for(Entry e: a[bucket]) {
            if(e.key == key) {
                e.value = value;
                return;
            }
        }

        a[bucket].offer(new Entry(key, value));
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        
        if(a[bucket] == null) return -1;

        for(Entry e: a[bucket]) {
            if(e.key == key) return e.getValue();
        }
        return -1;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        if(a[bucket] == null) return;

        a[bucket].remove(new Entry(key, -1));
    }

    static class Entry {
        int key; 
        Integer value;

        Entry(int key, Integer value) {
            this.key = key;
            this.value = value;
        }

        void putValue(Integer val) {
            this.value = val;
        }

        public Integer getValue() {
            if(value == null) return -1;
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if(o instanceof Entry that) {
                return this.key == that.key;
            }
            return false;
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