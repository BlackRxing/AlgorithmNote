package dfs;

public class _329_longest_increasing_path_in_a_matrix {

   //使用深度优先遍历，第一种写法效率更高，没有冗余，因为赋值是从下向上，每个点最多遍历一次
    class Solution {
        public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public int rows, columns;

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            rows = matrix.length;
            columns = matrix[0].length;
            int[][] memo = new int[rows][columns];
            int ans = 0;
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    ans = Math.max(ans, dfs(matrix, i, j, memo));
                }
            }
            return ans;
        }

        public int dfs(int[][] matrix, int row, int column, int[][] memo) {
            if (memo[row][column] != 0) {
                return memo[row][column];
            }
            memo[row][column]=1;    //这样写效率比较高
            for (int[] dir : dirs) {
                int newRow = row + dir[0], newColumn = column + dir[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                    memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
                }
            }
            return memo[row][column];
        }
    }

//从上向下赋值，有冗余，最坏情况复杂度为O去啊
    class Solution {
        private int[][] temp;
        private int result=0;
        public int longestIncreasingPath(int[][] matrix) {
            temp=new int[matrix.length][matrix[0].length];
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    if(temp[i][j]==0){
                        dfs(matrix,i,j,0);
                    }
                }
            }
            return result;
        }
        private void dfs(int[][] matrix,int i,int j,int depth){
            depth++;
            boolean flag=false;
            int[][] direction=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
            temp[i][j]=depth;
            for(int p=0;p<4;p++){
                int x=i+direction[p][0];
                int y=j+direction[p][1];
                if(x>=0&&x<matrix.length&&y>=0&&y<matrix[0].length&&matrix[i][j]>matrix[x][y]&&(depth+1)>temp[x][y]){
                    // System.out.println(x+" "+y+" "+i+" "+j+" "+depth);
                    flag=true;
                    dfs(matrix,x,y,depth);
                }
            }
            if(!flag&&depth>result){
                result=depth;
            }
        }
    }
}
