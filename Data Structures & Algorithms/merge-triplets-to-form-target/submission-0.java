class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] check = new boolean[3];
        Arrays.fill(check, false);

        for(int[] triplet : triplets){
            if(triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]){
                continue;
            }
            for(int i = 0; i < 3; i++){
                if(triplet[i] == target[i]){
                    check[i] = true;
                }
            }
        }

        return check[0] && check[1] && check[2];
    }
}
