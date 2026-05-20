class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int n: stones) q.offer(n);

        while(q.size() > 1) {
            int s1 = q.poll();
            int s2 = q.poll();
            int newW = Math.abs(s1-s2);
            
            if(newW > 0) q.offer(newW);
        }

        return q.size() == 0 ? 0 : q.poll();
    }
}
