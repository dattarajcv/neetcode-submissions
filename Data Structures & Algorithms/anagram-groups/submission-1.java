class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var result = new ArrayList<List<String>>();
        var processed = new int[strs.length];
        
        for(int i =0; i < strs.length;i++){
            if(processed[i] == 0){
            var list = new ArrayList<String>();
            list.add(strs[i]);
            for(int j = i+1; j< strs.length; j++){
                if(processed[j] == 0 && isAnagram(strs[i],strs[j])){
                    list.add(strs[j]);
                    processed[j]=1;
                }
            }
            processed[i] = 1;
            result.add(list);
            }
            
        }

        return result;
    }

    private boolean isAnagram(String a, String b){
        if(a.length() != b.length())
        return false;

        var count = new int[26];
        for(int i =0; i< a.length(); i++){
            count[a.charAt(i) - 'a']++;
            count[b.charAt(i) - 'a']--;
        }

        for(int val: count){
            if(val != 0)
            return false;
        }

        return true;
    }
}
