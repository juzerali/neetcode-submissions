class FreqStack {
    TreeMap<Integer, LinkedList<Integer>> freqs = new TreeMap<>();
    Map<Integer, Integer> nums = new HashMap<>();

    public FreqStack() {
        
    }
    
    public void push(int val) {
        int freq = nums.getOrDefault(val, 0) + 1;
        nums.put(val, freq);
        // removeValFromFreq(val, freq-1);

        freqs.putIfAbsent(freq, new LinkedList<>());
        freqs.get(freq).offerFirst(val);
    }
    
    public int pop() {
        // for(int key: freqs.keySet()) {
        //     System.out.println(key);
        //     System.out.println(freqs.get(key));
        // }
        // System.out.println(freqs.size());
        

        int highest = freqs.lastKey();
        LinkedList<Integer> ll = freqs.get(highest);
        Integer elem = ll.removeFirst();
        if(ll.size() == 0) freqs.remove(highest);

        int freq = highest-1;
        if(freq != 0) {
            nums.put(elem, freq);
            // freqs.putIfAbsent(freq, new LinkedList<>());
            // freqs.get(freq).offerLast(elem);
        } else {
            nums.remove(elem);
        }
        
        // System.out.println("=====");
        return elem;
    }

    private void removeValFromFreq(int val, int freq) {
        if(freqs.containsKey(freq)) {
            LinkedList<Integer> ll = freqs.get(freq);
            ll.removeFirstOccurrence(val);

            if(ll.size() == 0) freqs.remove(freq);
        }
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */