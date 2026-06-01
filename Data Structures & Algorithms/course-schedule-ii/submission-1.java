class Solution {
    Set<Integer> cycle = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    
    public int[] findOrder(int n, int[][] prerequisites) {
        DAG[] courses = new DAG[n];

        for(int i = 0; i < n; i++) {
            courses[i] = new DAG(i);
        }

        for(int[] pair: prerequisites) {
            courses[pair[0]].add(courses[pair[1]]);
        }

        cycle = new HashSet<>();
        visited = new HashSet<>();
        List<DAG> result = new ArrayList<>();

        for(DAG d: courses) {
            if(!dfs(d, result)) return new int[]{};
        }

        int[] out = new int[n];

        int i = 0;
        for(DAG d: result) {
            out[i++] = d.id;
        }

        return out;
    }

    private boolean dfs(DAG start, List<DAG> result) {
        // System.out.println(start.id);
        if(cycle.contains(start.id)) {
            // System.out.println("Cycle detected at: " + start.id);
            return false;
        }

        if(visited.contains(start.id)) return true;
        
        cycle.add(start.id);
        for(DAG d: start.prerequisites) {
            if(!dfs(d, result)) return false;
        }

        cycle.remove(start.id);
        visited.add(start.id);
        result.add(start);

        return true;
    }

    static class DAG {
        int id;
        List<DAG> prerequisites;

        DAG(int id) {
            this.id = id;
            prerequisites = new ArrayList<>();
        }

        public void add(DAG pre) {
            prerequisites.add(pre);
        }
    }
}
