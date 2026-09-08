class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet, colSet, sqrSet;

        // row and column check
        for(int i=0; i< 9; i++){
            
            rowSet = new HashSet<>();
            colSet = new HashSet<>();
            sqrSet = new HashSet<>();

            for(int j=0; j< 9; j++){
                if(board[i][j] != '.' && !rowSet.add(board[i][j])){
                    return false;
                }

                if(board[j][i] != '.' && !colSet.add(board[j][i])){
                    return false;
                }

                // Square check
                int row = 3 * (i / 3) + (j / 3);
                int col = 3 * (i % 3) + (j % 3);

                if(board[row][col] != '.' && !sqrSet.add(board[row][col])){
                    return false;
                }
            }

        }

        return true;
    }
}
