class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            if(bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        List<Integer> list = new ArrayList<>();
        int count = bucket.length;
        while(k > 0){
            count--;
            if(bucket[count] != null){
                list.addAll(bucket[count]);
                k -= bucket[count].size();
            }
        }

        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
