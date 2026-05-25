class Solution {
    public int[] asteroidCollision(int[] a) {
        int l = a.length;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < l;) {
            int ast = a[i];

            if(stack.isEmpty()) {
                stack.push(ast);
                i++;
                continue;
            }

            if(ast > 0) {
                stack.push(ast);
                i++;
            } else {
                if(stack.peek() > 0) {
                    int left = stack.pop();

                    if(left == -ast) {
                        i++;
                        continue;
                    }
                    if(left > -ast) {
                        stack.push(left);
                        i++;
                    }
                } else {
                    stack.push(ast);
                    i++;
                }
            }
        }

        int[] ans = new int[stack.size()];
        for(int i = ans.length-1; i >=0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
    }
}