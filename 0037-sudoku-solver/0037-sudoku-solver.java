class Solution {
    private boolean[][] rows = new boolean[9][9];   // rows[i][d] = true if digit d+1 used in row i
    private boolean[][] cols = new boolean[9][9];   // cols[j][d] = true if digit d+1 used in col j
    private boolean[][] boxes = new boolean[9][9];  // boxes[b][d] = true if digit d+1 used in box b
    private char[][] board;
    
    public void solveSudoku(char[][] board) {
        this.board = board;
        
        // Initialize constraint tracking arrays based on existing digits
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int d = board[i][j] - '1';
                    int b = boxIndex(i, j);
                    rows[i][d] = true;
                    cols[j][d] = true;
                    boxes[b][d] = true;
                }
            }
        }
        
        backtrack(0, 0);
    }
    
    private boolean backtrack(int row, int col) {
        // Move to next row when we pass the last column
        if (col == 9) {
            return backtrack(row + 1, 0);
        }
        // All rows processed successfully
        if (row == 9) {
            return true;
        }
        // Skip filled cells
        if (board[row][col] != '.') {
            return backtrack(row, col + 1);
        }
        
        int b = boxIndex(row, col);
        for (int d = 0; d < 9; d++) {
            if (!rows[row][d] && !cols[col][d] && !boxes[b][d]) {
                // Place digit
                place(row, col, b, d, true);
                
                if (backtrack(row, col + 1)) {
                    return true;
                }
                
                // Undo (backtrack)
                place(row, col, b, d, false);
            }
        }
        
        return false; // no valid digit works, trigger backtracking
    }
    
    private void place(int row, int col, int box, int d, boolean value) {
        rows[row][d] = value;
        cols[col][d] = value;
        boxes[box][d] = value;
        board[row][col] = value ? (char) ('1' + d) : '.';
    }
    
    private int boxIndex(int row, int col) {
        return (row / 3) * 3 + (col / 3);
    }
}