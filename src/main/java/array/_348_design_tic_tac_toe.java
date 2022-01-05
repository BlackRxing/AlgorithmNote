package array;
//通过直接记录每行每列，两个对角线，两个选手放置的个数来直接判断结果
public class _348_design_tic_tac_toe {
    class TicTacToe {

        private int[][] rows;
        private int[][] clos;
        private int[][] diagnals;
        private int n;
        public TicTacToe(int n) {
            rows=new int[3][n];//x=0不用，代码写起来更方便
            clos=new int[3][n];
            diagnals=new int[3][2];
            this.n=n;
        }

        public int move(int row, int col, int player) {
            if(++rows[player][row]==n){
                return player;
            }
            if(++clos[player][col]==n){
                return player;
            }
            if(row==col&&++diagnals[player][0]==n){  //正对角线
                return player;
            }
            if(col+row+1==n&&++diagnals[player][1]==n){  //反对角线
                return player;
            }
            return 0;
        }
    }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
}
