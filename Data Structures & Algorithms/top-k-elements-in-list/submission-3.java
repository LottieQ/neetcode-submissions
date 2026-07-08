class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> count = new HashMap<>();

        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            if(bucket[entry.getValue()] == null){
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        int[] ans = new int[k];
        for(int i = nums.length; i >= 0 && k > 0; i--){
            if(bucket[i] != null){
                for(int num: bucket[i]){
                    ans[--k] = num;
                }
            }
        }

        return ans;
    }
}
