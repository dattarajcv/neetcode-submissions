class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var res = new HashMap<String, List<String>>();
        for(String s: strs){
            var count = new int[26];
            for(char c: s.toCharArray()){
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key,new ArrayList<>());
            res.get(key).add(s);
        }

        return new ArrayList<>(res.values());
    }
}
