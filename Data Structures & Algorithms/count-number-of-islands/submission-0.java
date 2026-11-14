class Solution {
    Set<List<Integer>> visited = new HashSet<>();
    int rows;
    int columns;

    public void searchNeighbors(int row, int column, char[][] grid) {

        // Mark current position as visited
        visited.add(Arrays.asList(row, column));

        // Up
        if (row - 1 >= 0 &&
            grid[row - 1][column] == '1' &&
            !visited.contains(Arrays.asList(row - 1, column))) {

            searchNeighbors(row - 1, column, grid);
        }

        // Down
        if (row + 1 < rows &&
            grid[row + 1][column] == '1' &&
            !visited.contains(Arrays.asList(row + 1, column))) {

            searchNeighbors(row + 1, column, grid);
        }

        // Left
        if (column - 1 >= 0 &&
            grid[row][column - 1] == '1' &&
            !visited.contains(Arrays.asList(row, column - 1))) {

            searchNeighbors(row, column - 1, grid);
        }

        // Right
        if (column + 1 < columns &&
            grid[row][column + 1] == '1' &&
            !visited.contains(Arrays.asList(row, column + 1))) {

            searchNeighbors(row, column + 1, grid);
        }
    }

    public int numIslands(char[][] grid) {

        if (grid.length == 0)
            return 0;

        rows = grid.length;
        columns = grid[0].length;

        int islands = 0;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {

                List<Integer> currentPosition =
                    Arrays.asList(row, column);

                if (grid[row][column] == '1' &&
                    !visited.contains(currentPosition)) {

                    searchNeighbors(row, column, grid);
                    islands++;
                }
            }
        }

        return islands;
    }
}