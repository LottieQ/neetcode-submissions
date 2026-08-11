class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> nexts = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < numCourses; i++) {
            nexts.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites){
            int pre = prerequisite[1];
            int course = prerequisite[0];

            nexts.get(pre).add(course);
            indegree[course]++;
        }

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();
            count++;
            for(int next : nexts.get(curr)){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }

        return count == numCourses;

    }
}
