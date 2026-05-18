class Solution {
    /**
    1: 1
    2: 2
    3: 2
    4: 2
    5: 1



    **/
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(groupSize > hand.length) return false;
        if(groupSize == 1) return true;
        
        Arrays.sort(hand);

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int h: hand) {
            if(!map.containsKey(h)) map.put(h,0);
            map.put(h, map.get(h)+1);
        }

        int progress = 0;
        int last = -1;
        while(map.size() != 0) {
            if(progress == 0) {
                last = map.firstKey();
                map.put(last, map.get(last)-1);
                if(map.get(last) == 0) map.remove(last);
                progress++;
            } else {
                last = last+1;
                if(map.containsKey(last)) {
                    map.put(last, map.get(last)-1);
                    if(map.get(last) == 0) map.remove(last);
                    progress++;
                } else {
                    return false;
                }

                if(progress % groupSize == 0) progress = 0;
            }
        }

        return progress == 0;
    }
}
