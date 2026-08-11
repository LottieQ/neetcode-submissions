class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> ans = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer>[] nexts = new ArrayList[numCourses];

        Arrays.setAll(nexts, i -> new ArrayList<>());

        for(int[] prerequisite : prerequisites){
            int pre = prerequisite[1];
            int course = prerequisite[0];

            nexts[pre].add(course);
            indegree[course]++;
        }

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();
            ans.add(curr);

            for(int next : nexts[curr]){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }

        if(ans.size() == numCourses){
            int[] res = new int[numCourses];
            for(int i = 0; i < numCourses; i++){
                res[i] = ans.get(i);
            }
            return res;
        }

        return new int[]{};
    }
}
