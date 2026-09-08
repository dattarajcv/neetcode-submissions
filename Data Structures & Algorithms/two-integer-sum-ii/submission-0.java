class Solution {
    public int[] twoSum(int[] numbers, int target) {

        // Result array to store 1-based indices as required by the problem
        int[] result = new int[2];

        int n = numbers.length;

        /*
         * Two pointers:
         * - left starts at the beginning (smallest value)
         * - right starts at the end (largest value)
         * Since the array is sorted, we can adjust pointers
         * based on whether the sum is too small or too large.
         */
        int left = 0, right = n - 1;

        // Continue until the two pointers cross
        while (left < right) {

            int currentSum = numbers[left] + numbers[right];

            /*
             * If the sum equals the target, we found the answer.
             * Problem requires 1-based indexing, so add 1.
             */
            if (currentSum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
            /*
             * If the sum is greater than the target,
             * move the right pointer left to reduce the sum.
             */
            else if (currentSum > target) {
                right--;
            }
            /*
             * If the sum is smaller than the target,
             * move the left pointer right to increase the sum.
             */
            else {
                left++;
            }
        }

        // Return the indices of the two numbers that sum to the target
        return result;
    }
}
