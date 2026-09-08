class TimeMap {

    class Pair<A, B> {
        private A first;
        private B second;

        public Pair(A f, B s) {
            this.first = f;
            this.second = s;
        }

        public A getFirst() {
            return first;
        }

        public B getSecond() {
            return second;
        }

    }

    Map<String, List<Pair<String, Integer>>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Pair<String, Integer> pair = new Pair<>(value, timestamp);

        timeMap.computeIfAbsent(key, k -> new ArrayList<>())
                .add(pair);
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }

        List<Pair<String, Integer>> list = timeMap.get(key);
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int midIndex = left + (right - left) / 2;

            Pair<String, Integer> mid = list.get(midIndex);

            if (timestamp == mid.getSecond()) {
                return mid.getFirst();
            }

            if (timestamp < mid.getSecond()) {
                right = midIndex - 1;
            } else {
                left = midIndex + 1;
            }
        }
        if(right < 0){
            return "";
        }
        return list.get(right).getFirst();
    }
}