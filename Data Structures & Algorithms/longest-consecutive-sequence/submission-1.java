class Solution {
    public int longestConsecutive(int[] nums) {
        Set store = new HashSet<Integer>();

        for (int n : nums) {
            store.add(n);
        }
        // [2,20,4,10,3,4,5]
        // store 2, 3, 4, 5, 10, 20
        int longest = 0;

        for (int n : nums) {
            if (!store.contains(n - 1)) {
                int curr = n;
                int len = 1;

                while (store.contains(curr + 1)) {
                    curr++;
                    len++;
                }

                longest = len > longest ? len : longest;
            }
        }

        return longest;
    }
}
