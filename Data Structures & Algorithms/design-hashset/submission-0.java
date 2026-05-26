class MyHashSet {
    boolean[] buckets = new boolean[1000001];
    
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        buckets[key] = true;
    }
    
    public void remove(int key) {
        buckets[key] = false;
    }
    
    public boolean contains(int key) {
        return buckets[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */