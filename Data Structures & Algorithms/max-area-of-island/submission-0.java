class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    result = Math.max(result, dfs(grid, i, j));
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int r, int c){
        int rowSize = grid.length;
        int columnSize = grid[0].length;
        if(r < 0 || r >= rowSize || c < 0 || c >= columnSize || grid[r][c] == 0) return 0;
        boolean count = false;
        if (grid[r][c] == 1){
            count = true;
            grid[r][c] = 0;
        }

        int left = dfs(grid, r, c - 1);
        int right = dfs(grid, r, c + 1);
        int up = dfs(grid, r + 1, c);
        int down = dfs(grid, r - 1, c);


        return count ? 1 + left + right + up + down : 0;
    }
}
