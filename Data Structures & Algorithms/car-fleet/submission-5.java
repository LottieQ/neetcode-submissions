class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> list = new ArrayList<>();
        int ans = 0;

        for(int i = 0; i < position.length; i++){
            list.add(new int[]{position[i], speed[i]});
        }

        list.sort((a, b) -> Integer.compare(b[0], a[0]));
        
        double slowest = 0.0;
        for(int[] car: list){
            double time = (target - car[0]) * 1.0 / car[1] ;
            if(time > slowest){
                slowest = time;
                ans++;
            }
        }

        return ans;
    }
}
