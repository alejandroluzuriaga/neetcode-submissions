class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Caso base: matriz de un solo elemento
        if (rows == 1 && cols == 1)
            return matrix[0][0] == target;

        // Comprobamos los extremos
        if (target < matrix[0][0] || target > matrix[rows - 1][cols - 1])
            return false;

        // Dividimos por filas si hay más de una
        if (rows > 1) {
            int mid = rows / 2;

            if (target < matrix[mid][0]) {
                int[][] subMatrix = new int[mid][cols];

                for (int i = 0; i < mid; i++) {
                    for (int j = 0; j < cols; j++) {
                        subMatrix[i][j] = matrix[i][j];
                    }
                }

                return searchMatrix(subMatrix, target);

            } else {
                int[][] subMatrix = new int[rows - mid][cols];

                for (int i = mid; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        subMatrix[i - mid][j] = matrix[i][j];
                    }
                }

                return searchMatrix(subMatrix, target);
            }
        }

        // Si solo queda una fila, dividimos por columnas
        int mid = cols / 2;

        if (target < matrix[0][mid]) {
            int[][] subMatrix = new int[1][mid];

            for (int j = 0; j < mid; j++) {
                subMatrix[0][j] = matrix[0][j];
            }

            return searchMatrix(subMatrix, target);

        } else {
            int[][] subMatrix = new int[1][cols - mid];

            for (int j = mid; j < cols; j++) {
                subMatrix[0][j - mid] = matrix[0][j];
            }

            return searchMatrix(subMatrix, target);
        }
    }
}