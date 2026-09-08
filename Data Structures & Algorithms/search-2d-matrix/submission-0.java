class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Get dimensions of the matrix
        int m = matrix.length;      // number of rows
        int n = matrix[0].length;   // number of columns
        
        // Treat the 2D matrix as a flattened 1D sorted array
        // with indices from 0 to (m*n - 1)
        int left = 0;           // start of search space
        int right = m*n - 1;    // end of search space

        // Standard binary search
        while(left <= right){
            // Calculate middle index to avoid overflow
            int mid = left + (right - left)/2;
            
            // Convert 1D index back to 2D matrix coordinates
            int row = mid/n;    // which row (integer division)
            int col = mid%n;    // which column (remainder)
        
            // Check if we found the target
            if(target == matrix[row][col]){
                return true;
            }

            // Target is smaller, search left half
            if(target < matrix[row][col]){
                right = mid - 1;
            }
            // Target is larger, search right half
            else{
                left = mid + 1;
            }
        }

        // Target not found in matrix
        return false;
    }
}