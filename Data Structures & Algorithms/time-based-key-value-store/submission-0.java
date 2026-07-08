class TimeMap {

    private Map<String, List<Pair<Integer, String>>> keyStore;
    
    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        String result = "";
        
        if(!keyStore.containsKey(key)) return result;
        List<Pair<Integer, String>> values = keyStore.get(key);
        int left = 0;
        int right = values.size() - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(values.get(mid).getKey() <= timestamp){
                result = values.get(mid).getValue();
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return result;
    }

    private static class Pair<K , V>{
        private final K key;
        private final V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }
    }
}
