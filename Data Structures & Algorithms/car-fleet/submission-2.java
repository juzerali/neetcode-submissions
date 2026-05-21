class Solution {

    // v1 = {pos: 0, speed: 2}
    // v2 = {pos: 2, speed: 3}
    // v3 = {pos: 4, speed: 1}


    // v1 = {pos: 0, speed: 1}
    // v2 = {pos: 1, speed: 2}
    // v1 = {pos: 4, speed: 2}
    // v1 = {pos: 7, speed: 1}
    public int carFleet(int target, int[] position, int[] speed) {
        int l = speed.length;

        if(l == 0) return 0;

        Vector[] vs = new Vector[l];

        for(int i = 0; i < l; i++) {
            vs[i] = new Vector(position[i], speed[i]);
        }

        Arrays.sort(vs, new DistComparator());

        int fleets = 1;
        Vector slowest = vs[l-1];

        for(int i = l-2; i >= 0; i--) {
            Vector v = vs[i];

            if(!v.canCatchupInTimeWith(slowest, target)) {
                // System.out.println(v);
                slowest = v;
                fleets++;
            }
            // System.out.println(fleets);
        }

        return fleets;
    }
        
    
    
    class Vector {
        int pos; int vel;

        Vector(int pos, int vel) {
            this.pos = pos;
            this.vel = vel;
        }

        float time(int target) {
            float time = (float) (target-pos)/vel;
            // System.out.println(time);
            return time;
        }

        // s = d/t
        boolean canCatchupWith(Vector v2) {
            boolean result = (vel > v2.vel) || caughtUpWith(v2);
            // System.out.println(pos + ", " + vel + ": " + result);
            return result;
        }

        boolean caughtUpWith(Vector v2) {
            return this.pos == v2.pos;
        }

        float catchUpTimeWith(Vector v2) {
            if(!canCatchupWith(v2)) return -1;

            return (float) (v2.pos - pos)/(vel-v2.vel);
        }

        /**
            // v1 = {pos: 0, speed: 2}
            // v2 = {pos: 2, speed: 3}
        **/
        boolean canCatchupInTimeWith(Vector v2, int target) {
            // System.out.println(this);
            // System.out.println(v2);

            if(!canCatchupWith(v2)) return false;



            return time(target) <= v2.time(target);
        }

        public String toString() {
            return "[" + pos + ", " + vel + "]";
        }
    }

    class DistComparator implements Comparator<Vector> {

        @Override
        public int compare(Vector a, Vector b) {
            return a.pos - b.pos;
        }
    }
}

/**

{pos:: 2, speed: 5}
{pos:: 4, speed: 9}
{pos:: 5, speed: 10}
{pos:: 6, speed: 4}

{pos:: 7, speed: 5} ttt = 
{pos:: 10, speed: 7} ttt = 2h
{pos:: 11, speed: 1} ttt = 2h

target = 13
**/

