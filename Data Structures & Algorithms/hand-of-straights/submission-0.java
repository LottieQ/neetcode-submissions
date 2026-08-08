class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int card : hand){
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        while(!map.isEmpty()){
            int smallest = map.firstKey();
            for(int i = 0; i < groupSize; i++){
                if(!map.containsKey(smallest)){
                    return false;
                }
                map.put(smallest, map.get(smallest) - 1);
                if(map.get(smallest) <= 0){
                    map.remove(smallest);
                }
                smallest++;
            }
        }

        return true;
    }
}
