class TimeMap {

    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        int targetIdx = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            Pair currSet = list.get(mid);
            if(currSet.getTime() <= timestamp){
                targetIdx = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return targetIdx == -1 ? "" : list.get(targetIdx).getValue();
    }
}

class Pair{
    String value;
    int timestamp;

    public Pair(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getValue(){
        return value;
    }

    public int getTime(){
        return timestamp;
    }
}
