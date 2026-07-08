class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];
        int[] ans = new int[k];

        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            if(buckets[entry.getValue()] == null){
                buckets[entry.getValue()] = new ArrayList<>();
            }
            buckets[entry.getValue()].add(entry.getKey());
        }

        for(int i = buckets.length - 1; i > 0 && k > 0; i--){
            if(buckets[i] != null){
                for(int num : buckets[i]){
                    ans[k - 1] = num;
                    k--;
                }
            }
        }
        return ans;
    }
}
