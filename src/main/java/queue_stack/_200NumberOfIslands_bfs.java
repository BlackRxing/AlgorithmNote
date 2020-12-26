package queue_stack;

import java.util.LinkedList;
import java.util.Queue;

public class _200NumberOfIslands_bfs {
        public int numIslands(char[][] grid) {
            if(grid==null||grid.length==0){
                return 0;
            }
            int nr=grid.length;
            int nc=grid[0].length;
            int result=0;
            for(int i=0;i<nr;++i){
                for(int j=0;j<nc;++j){
                    if(grid[i][j]=='1'){
                        result++;
                        Queue<Integer> neighbors=new LinkedList<>();
                        neighbors.add(i*nc+j);
                        while(!neighbors.isEmpty()){
                            int id=neighbors.remove();
                            int row=id/nc;
                            int clo=id%nc;
                            if(row-1>=0&&grid[row-1][clo]=='1'){
                                grid[row-1][clo]='0';
                                neighbors.add((row-1)*nc+clo);
                            }
                            if(row+1<nr&&grid[row+1][clo]=='1'){
                                grid[row+1][clo]='0';
                                neighbors.add((row+1)*nc+clo);
                            }
                            if(clo-1>=0&&grid[row][clo-1]=='1'){
                                grid[row][clo-1]='0';
                                neighbors.add(row*nc+clo-1);
                            }
                            if(clo+1<nc&&grid[row][clo+1]=='1'){
                                grid[row][clo+1]='0';
                                neighbors.add(row*nc+clo+1);
                            }
                        }
                    }
                }
            }
            return result;
        }


}
