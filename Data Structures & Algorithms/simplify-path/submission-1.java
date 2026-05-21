class Solution {
    public String simplifyPath(String path) {
        String[] crumbs = path.split("/");
        Stack<String> stack = new Stack();

        for(String s: crumbs) {
            if(s.equals("..")) {
                if(!stack.isEmpty()) stack.pop();

            } else if(!(s.equals(".") || s.isEmpty())) {
                stack.push(s);
            }
        }

        return "/" + String.join("/", stack);
    }
}