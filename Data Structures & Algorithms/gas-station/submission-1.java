class Solution {
    /**
        gas=   [1,2,3,4,5]
        cost=  [3,4,5,1,2]
        gain = [-2,-2,-2,3,3]

        tank = 0
        start = 4

        i = 4
        gain = 3

        Is tank + gain (0) >= 0? false


    **/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        if(n == 0) return 0;

        for(int i = 0; i < n; i++) {
            int tank = 0;

            for(int j = 0; j < n; j++) {
                tank += gas[(i+j)%n] - cost[(i+j)%n];
                if(tank < 0) break;
            }

            if(tank >= 0) return i;
        }

        return -1;
    }
}
