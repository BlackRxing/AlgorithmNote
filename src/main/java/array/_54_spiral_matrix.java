package array;

import java.util.ArrayList;
import java.util.List;

//建议参考59号题，最好不用下面注释的写法，比较复杂还需要修改。此类题目可以统一参考下类写法；
//首先要判断宽型还是窄型，这决定了loop的大小，遍历的次数
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        int xt=0,yt=0,count=1;
        int xl=matrix.length,yl=matrix[0].length;
        boolean isVertical=xl>yl?true:false;
        int loop=xl>yl?yl:xl;
        for(int i=0;i<loop/2;i++){
            for(int y=yt;y<yl-yt;y++){
                result.add(matrix[xt][y]);
                System.out.println('1');
            }
            for(int x=xt+1;x<xl-xt;x++){
                result.add(matrix[x][yl-yt-1]);
                System.out.println('2');
            }
            for(int y=yl-yt-2;y>=yt;y--){
                result.add(matrix[xl-xt-1][y]);
                System.out.println('3');
            }
            for(int x=xl-xt-2;x>xt;x--){
                result.add(matrix[x][yt]);
                System.out.println('4');
            }
            xt++;
            yt++;
        }
        //对宽型和窄型分别做处理
        if(loop%2==1){
            if(isVertical){
                for(int x=xt;x<xl-xt;x++){
                    result.add(matrix[x][yt]);
                }
            }else{
                for(int y=yt;y<yl-yt;y++){
                    result.add(matrix[xt][y]);
                }
            }
        }
        return result;
    }
}

//public class _54_spiral_matrix {
//    class Solution {
//        public List<Integer> spiralOrder(int[][] matrix) {
//            List<Integer> result=new ArrayList<>();
//            int xt=0,yt=0,count=1;
//            int xl=matrix.length,yl=matrix[0].length;
//            int loop=xl>yl?yl:xl;
//            loop=(loop%2==1)?loop=loop/2+1:loop/2;
//            for(int i=0;i<loop;i++){
//                for(int y=yt;y<yl-yt;y++){
//                    result.add(matrix[xt][y]);
//                    System.out.println('1');
//                }
//                for(int x=xt+1;x<xl-xt;x++){
//                    result.add(matrix[x][yl-yt-1]);
//                    System.out.println('2');
//                }
//                for(int y=yl-yt-2;y>=yt;y--){
//                    result.add(matrix[xl-xt-1][y]);
//                    System.out.println('3');
//                }
//                for(int x=xl-xt-2;x>xt;x--){
//                    result.add(matrix[x][yt]);
//                    System.out.println('4');
//                }
//                xt++;
//                yt++;
//            }
//            return result;
//        }
//    }
//}
