class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int ans = 0;
        double time = 0.0;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < position.length; i++){
            list.add(new int[]{position[i], speed[i]});
        }

        list.sort((a , b) -> Integer.compare(b[0] , a[0]));

        for(int[] car: list){
            double currTime = (double)(target - car[0]) / car[1];
            if(currTime > time){
                ans++;
                time = currTime;
            }
        }
        return ans;

    }
}
