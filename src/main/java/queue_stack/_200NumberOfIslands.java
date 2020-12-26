package queue_stack;

class _200NumberOfIslands {
    static int row;
    static int clo;

    public static void main(String[] args) {
        char[][] grid={{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','1','0','0'},
                {'0','0','0','0','1'}};
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {

        if(grid==null||grid.length==0){
            return 0;
        }
        row=grid.length;
        clo=grid[0].length;
        int answer=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<clo;j++){
                if(grid[i][j]=='1'){
                    answer++;
                    dfs(grid,i,j);
                }
            }
        }
        return answer;

    }
    static void dfs(char[][] grid,int x,int y){
        if(x<0||x>=row||y<0||y>=clo||grid[x][y]=='0'){
            return;
        }
        grid[x][y]='0';
        dfs(grid,x-1,y);
        dfs(grid,x+1,y);
        dfs(grid,x,y-1);
        dfs(grid,x,y+1);
    }

}
