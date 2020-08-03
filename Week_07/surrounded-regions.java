class Solution {
    public void solve(char[][] board) {
        //遍历边上的O
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1)
                    && board[i][j] == 'O') {
                dfs(board, i, j);
                }
            }
        }

        // 把K改成O，其他改成X
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] == 'K' ? 'O' : 'X';
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {

        if ((row < 0
                || row >= board.length
                || col < 0
                || col >= board[0].length
                || board[row][col] == '0')
            || board[row][col] == 'X'
            || board[row][col] == 'K') {
        return;
        }

        board[row][col] = 'K';

        dfs(board, row - 1, col);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
        dfs(board, row, col + 1);
    }    
}