class Solution {
    private int ROWS, COLS;
    private Set<Pair<Integer, Integer>> path = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

         for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean dfs(char[][] board, String word, int r, int c, int i){
        if(i == word.length()){
            return true;
        }

        Pair pair = new Pair<>(r,c);

        if(r < 0 || c < 0 || r >= ROWS || c >= COLS ||
        board[r][c] != word.charAt(i) || 
        path.contains(pair)){
            return false;
        }



        path.add(pair);

        boolean found = dfs(board, word, r, c +1, i+1) ||
        dfs(board, word, r, c -1, i+1) ||
        dfs(board, word, r + 1, c, i+1) ||
        dfs(board, word, r - 1, c, i+1);

        path.remove(pair);

        return found;
    }
}
