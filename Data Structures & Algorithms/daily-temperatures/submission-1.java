class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] t = temperatures;
        int size = temperatures.length;
        int[] result = new int[size];

        result[size-1] = 0;
        
        Stack<Integer> s = new Stack<>();

        s.push(size-1);

        for(int i = size-2; i >= 0; i--) {
            while(!s.isEmpty() && t[s.peek()] <= t[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                result[i] = 0;
                s.push(i);
            } else {
                result[i] = s.peek()-i;
                s.push(i);
            }
                
        }

        return result;
    }
}
