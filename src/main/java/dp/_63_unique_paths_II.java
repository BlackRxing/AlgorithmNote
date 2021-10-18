package dp;

public class _63_unique_paths_II {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m=obstacleGrid.length;
            int n=obstacleGrid[0].length;
            int[][] record=new int[m][n];
            for(int i=0;i<m;i++){
                if(obstacleGrid[i][0]==1){
                    break;
                }
                record[i][0]=1;
            }
            for(int i=0;i<n;i++){
                if(obstacleGrid[0][i]==1){
                    break;
                }
                record[0][i]=1;
            }
            for(int i=1;i<m;i++){
                for(int j=1;j<n;j++){
                    if(obstacleGrid[i][j]==1){
                        record[i][j]=0;
                    }else{
                        record[i][j]=record[i][j-1]+record[i-1][j];
                    }
                }
            }
            return record[m-1][n-1];
        }
    }
}
