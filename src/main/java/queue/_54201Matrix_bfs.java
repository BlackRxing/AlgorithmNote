package queue;

import java.util.LinkedList;
import java.util.Queue;

//第一轮将所有0的坐标放入queue，所有1换成-1（表示没有经过遍历），从每一个0开始向周围扩散（BFS）
class Solution542 {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    queue.offer(new int[] {i,j});
                }else{
                    matrix[i][j]=-1;
                }
            }
        }
        int[] dx=new int[] {-1,1,0,0};
        int[] dy=new int[] {0,0,1,-1};
        while(!queue.isEmpty()){
            int[] point=queue.poll();
            int row=point[0],clo=point[1];
            for(int i=0;i<4;i++){
                int newrow=row+dx[i];
                int newclo=clo+dy[i];
                if(newrow>=0&&newrow<m&&newclo>=0&&newclo<n&&matrix[newrow][newclo]==-1){
                    matrix[newrow][newclo]=matrix[row][clo]+1;
                    queue.offer(new int[]{newrow,newclo});
                }
            }
        }
        return matrix;
    }
}


