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

        String out = "";

        while(!stack.isEmpty())
        out = stack.pop() + "/" + out;

        if(out.length() == 0) return "/";
        if(out.length() < 2) return out;

        return "/" + out.substring(0, out.length()-1);
    }
}