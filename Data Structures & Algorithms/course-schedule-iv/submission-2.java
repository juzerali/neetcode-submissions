


class Solution {
    private Set<Integer> cycle = new HashSet<>();
    private Set<Integer> visited = new HashSet<>();

    Map<Query, Boolean> memo = new HashMap<>();

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Node[] dags = new Node[n];

        for(int i = 0; i < n; i++) dags[i] = new Node(i);

        for(int[] pre: prerequisites) {
            dags[pre[1]].add(dags[pre[0]]);
        }

        List<Boolean> ans = new ArrayList<>();

        for(int[] query: queries) {
            cycle.clear();
            visited.clear();
            System.out.println(query[0] + ":" + query[1]);
            ans.add(isPrerequisite(dags[query[0]], dags[query[1]]));
        }

        return ans;
    }

    public boolean isPrerequisite(Node pre, Node root) {
        Query q = new Query(root.val, pre.val);

        if(memo.containsKey(q)) return memo.get(q);
        boolean result = false;

        if(root == pre) {
            result = true;
        } else if(cycle.contains(root.val)) result = false;
        else {
            cycle.add(root.val);
            for(Node next: root.next) {
                if(isPrerequisite(pre, next)) {
                    result = true;
                    break;
                }
            }

            visited.add(root.val);
            cycle.remove(root.val);
        }

        memo.put(q, result);
        return result;
    }

    class Query {
        int node;
        int prerequisite;

        Query(int node, int prerequisite) {
            this.node = node;
            this.prerequisite = prerequisite;
        }

        @Override
        public boolean equals(Object o) {
            if(o instanceof Query that) {
                return this.node == that.node && this.prerequisite == that.prerequisite;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.node * 1013 + this.prerequisite;
        }
    }

    class Node {
        int val;
        Set<Node> next;

        Node(int val) {
            this.val = val;
            next = new HashSet<>();
        }

        @Override
        public boolean equals(Object o) {
            if(o instanceof Node that) {
                return this.val == that.val;
            }

            return false;
        }

        void add(Node d) {
            next.add(d);
        }
    }
}
