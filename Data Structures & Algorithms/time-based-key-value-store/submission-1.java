class TimeMap {
    Map<String, TreeMap<Integer, String>> map = new HashMap<>();

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            this.map.put(key, new TreeMap<>());
        }

        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        Integer ts = this.map.get(key).floorKey(timestamp);

        if(ts == null) return "";

        return this.map.get(key).get(ts);
    }
}
