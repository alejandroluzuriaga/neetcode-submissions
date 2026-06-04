class Solution {
    public boolean isValidSudoku(char[][] board) {
        //mapa filas
            //fila 1 -> [1,2]
        //mapa columnas 
            // columna 1-> [1,4]
        //mapa cuadro
            // cuadro 1 -> [1,2,4,9,8]

        //boxes en 
            //[0,0], [0,3], [0,6]
            //[3,0], [3,3], [3,6]
            //[6,0], [6,3], [6,6]
        
        HashMap<Integer, List<Character>> rowsMap = new HashMap<>();
        HashMap<Integer, List<Character>> colsMap = new HashMap<>();
        HashMap<Integer, List<Character>> boxMap = new HashMap<>();
        int boxes = 0;
        for(int row = 0; row < board.length; row++){
            if (!rowsMap.containsKey(row))
                rowsMap.put(row, new LinkedList<>());

            for (int column = 0;  column < board[0].length; column++){
                if (!colsMap.containsKey(column))
                    colsMap.put(column, new LinkedList<>());

                if(row <= 2 && column <= 2){ //box 1
                    boxes = 0;
                    if (row == 0 && column == 0){
                        boxMap.put(0, new LinkedList<>());
                    }
                }
                if(row <= 2 && column >= 3 && column <= 5){ //box 2
                   boxes = 1;
                   if (row == 0 && column == 3){
                        boxMap.put(1, new LinkedList<>());
                        
                    }
                }
                if(row <= 2 && column >= 6 && column <= 8){ //box 3
                boxes = 2;
                   if (row == 0 && column == 6){
                        boxMap.put(2, new LinkedList<>());
                        
                    }
                }
                if(row >= 3 && row <= 5 && column <= 2){ //box 4
                boxes = 3;
                   if (row == 3 && column == 0){
                        boxMap.put(3, new LinkedList<>());
                        
                    }
                }
                if(row >= 3 && row <= 5 && column >= 3 && column <= 5){ //box 5
                boxes = 4;
                   if (row == 3 && column == 3){
                        boxMap.put(4, new LinkedList<>());
                        
                    }
                }
                if(row >= 3 && row <= 5 && column >= 6 && column <= 8){ //box 6
                boxes = 5;
                   if (row == 3 && column == 6){
                        boxMap.put(5, new LinkedList<>());
                        
                    }
                }
                if(row >= 6 && row <= 8 && column <= 2){ //box 7
                boxes = 6;
                   if (row == 6 && column == 0){
                        boxMap.put(6, new LinkedList<>());
                        
                    }
                }
                if(row >= 6 && row <= 8 && column >= 3 && column <= 5){ //box 8
                boxes = 7;
                   if (row == 6 && column == 3){
                        boxMap.put(7, new LinkedList<>());
                        
                    }
                }
                if(row >= 6 && row <= 8 && column >= 6 && column <= 8){ //box 9
                boxes = 8;
                   if (row == 6 && column == 6){
                        boxMap.put(8, new LinkedList<>());
                    }
                }

                if (rowsMap.containsKey(row))
                    if (rowsMap.get(row).contains(board[row][column]))
                        return false;
                if (colsMap.containsKey(column))
                    if (colsMap.get(column).contains(board[row][column]))
                        return false;
                if (boxMap.containsKey(boxes))
                    if (boxMap.get(boxes).contains(board[row][column]))
                        return false;

                if (board[row][column] != '.'){
                    if (rowsMap.containsKey(row))
                        rowsMap.get(row).add(board[row][column]);
                    if (colsMap.containsKey(column))
                        colsMap.get(column).add(board[row][column]);
                    if (boxMap.containsKey(boxes)){
                        boxMap.get(boxes).add(board[row][column]);
                    }
                }
            }
        }
        return true;
    }
}
