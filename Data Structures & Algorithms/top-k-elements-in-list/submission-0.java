class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] freq = new int[2001];

        for(int i: nums) {
            freq[i+1000]++;
        }

        PriorityQueue<Elem> pq = new PriorityQueue<>();

        for(int i = 0; i < freq.length; i++) {
            pq.add(new Elem(i-1000, freq[i]));
            if(pq.size() > k) pq.poll();
        }

        int[] result = new int[k];
        int i = 0;
        for(Elem e: pq) {
            result[i++] = e.num;
        }

        return result;
    }

    class Elem implements Comparable<Elem> {
        int num;
        int freq;

        Elem(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        public int compareTo(Elem that) {
            return this.freq - that.freq;
        }
    }
}
