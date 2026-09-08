class Solution {

    public String encode(List<String> strs) {
        var sb = new StringBuilder();
        for (String s : strs) {
        sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
    int i = 0;

    while (i < s.length()) {
        int j = i;
        while (s.charAt(j) != '#') j++;

        int len = Integer.parseInt(s.substring(i, j));
        j++; // skip '#'

        res.add(s.substring(j, j + len));
        i = j + len;
    }
    return res;
    }
}
