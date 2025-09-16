package backtracking;

public class NQueens {
    static int N = 8;

    private static boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1) return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;

        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1) return false;

        return true;
    }

    private static boolean solveNQ(int[][] board, int col) {
        if (col >= N) return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQ(board, col + 1)) return true;

                board[i][col] = 0; // backtrack
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        if (solveNQ(board, 0)) {
            for (int[] row : board) {
                System.out.println(java.util.Arrays.toString(row));
            }
        } else {
            System.out.println("No solution exists");
        }
    }
}
