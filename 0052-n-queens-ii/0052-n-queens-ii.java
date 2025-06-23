class Solution {
    public boolean isSafe(char board[][], int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q')
                return false;
        }

        //diagonally up left-top
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        //diagonally up right-top
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    public void nQueens(char board[][], int row) {
        if (row == board.length) {
            totalWays++;
            return;
        }

        for (int j = 0; j < board[0].length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = 'X';
            }
        }
    }

    public void print(char board[][]) {
        System.out.println("-------- Chesse Board ---------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int totalWays;

    public void call(int n) {
        char board[][] = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 'X';
            }
        }

        nQueens(board, 0);
        // System.out.println(nQueensTotalWays.totalWays);
    }

    public int totalNQueens(int n) {
        totalWays = 0; // \U0001f448 reset before each call
        call(n);
        return Solution.totalWays;
    }
}