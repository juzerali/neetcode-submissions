class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Coordinates> q = new PriorityQueue<>();

        for(int[] p: points) {
            q.offer(new Coordinates(p[0], p[1]));

            if(q.size() > k) q.remove();
        }

        return q.stream().map(c -> c.toArray()).toArray(int[][]::new);
    }

    static class Coordinates implements Comparable<Coordinates> {
        int x, y;

        Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distanceFromOriginSquared() {
            return y*y + x*x;
        }

        @Override
        public int compareTo(Coordinates c) {
            return -this.distanceFromOriginSquared() + c.distanceFromOriginSquared();
        }

        int[] toArray() {
            return new int[]{x,y};
        }
    }
}
