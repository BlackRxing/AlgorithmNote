package recall;

public class _37_sudoku_solver {
    class Solution {
        public void solveSudoku(char[][] board) {
            backTracking(board,0,0);
        }
        public boolean backTracking(char[][] board,int x,int y){
            if(x==9){
                return true;
            }
            if(board[x][y]!='.'){                                //这一步容易漏掉，和下面同样处理
                if(y==8){
                    if(backTracking(board,x+1,0))
                        return true;
                }else{
                    if(backTracking(board,x,y+1))
                        return true;
                }
            }else{
                for(int i=1;i<=9;i++){
                    if(isValidSudoku(x,y,(char)(i+'0'),board)){
                        board[x][y]=(char)(i+'0');
                        if(y==8){
                            if(backTracking(board,x+1,0))
                                return true;
                        }else{
                            if(backTracking(board,x,y+1))
                                return true;
                        }
                        board[x][y]='.';
                    }
                }
            }

            return false;
        }
        private boolean isValidSudoku(int row, int col, char val, char[][] board){
            // 同行是否重复
            for (int i = 0; i < 9; i++){         //9不能写成col。。。。。 因为里面本来填了一部分数，九空格内右下方可能有数字
                if (board[row][i] == val){
                    return false;
                }
            }
            // 同列是否重复
            for (int j = 0; j < 9; j++){
                if (board[j][col] == val){
                    return false;
                }
            }
            // 9宫格里是否重复
            int startRow = (row / 3) * 3;          //这里的*3容易漏掉！
            int startCol = (col / 3) * 3;
            for (int i = startRow; i < startRow + 3; i++){
                for (int j = startCol; j < startCol + 3; j++){
                    if (board[i][j] == val){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
