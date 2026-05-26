class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n: nums) map.put(n, map.getOrDefault(n,0)+1);

        int maj = 0;
        int count = 0;

        for(int key: map.keySet()) {
            if(map.get(key) > count) {
                maj = key;
                count = map.get(key);
            }
        }

        return maj;
    }
}