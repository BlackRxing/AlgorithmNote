package array;
//从外圈向内圈遍历，循环范围判断可以举例子（这样子最快），注意每一次四个方向遍历的范围，容易重复赋值。
//注意，将第10行i<loop不变的话，注释部分才可以加上
//对于54题不建议这么写，用注释的写法！
public class _59_spiral_matrix_II {
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] result=new int[n][n];
            int xt=0,yt=0,count=1;
            int loop=n/2;
            for(int i=0;i<=loop;i++){
                for(int y=yt;y<n-yt;y++){
                    result[xt][y]=count++;
                }
                for(int x=xt+1;x<n-xt;x++){
                    result[x][n-yt-1]=count++;
                }
                for(int y=n-yt-2;y>=yt;y--){
                    result[n-xt-1][y]=count++;
                }
                for(int x=n-xt-2;x>xt;x--){
                    result[x][yt]=count++;
                }
                xt++;
                yt++;
            }
//            if(n%2!=0){
//                result[n/2][n/2]=count;
//            }
            return result;
        }
    }
}
