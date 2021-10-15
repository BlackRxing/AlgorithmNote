package recall;

import java.util.ArrayList;
import java.util.List;


//我的写法比较简洁，查找是否有效更快，但ans可以最后再生成，动态path比较消耗时间
public class _51_n_queens {
    class Solution {
        List<List<String>> res=new ArrayList();
        List<String> path=new ArrayList();
        public List<List<String>> solveNQueens(int n) {
            int[] flag=new int[n];
            String s="";
            for(int i=0;i<n;i++){
                s+=".";
            }
            backTracking(0,flag,n,s);
            return res;
        }
        public void backTracking(int depth,int[] flag,int n,String s){
            if(depth==n){
                res.add(new ArrayList(path));
                return;
            }
            depth+=1;
            for(int i=0;i<n;i++){
                if(flag[i]==0){
                    boolean isValid=true;
                    for(int j=0;j<n;j++){
                        if(flag[j]!=0&&Math.abs(i-j)==Math.abs(depth-flag[j])){
                            isValid=false;
                        }
                    }
                    if(isValid){
                        String line=s.substring(0,i)+'Q'+s.substring(i+1,s.length());
                        path.add(line);
                        flag[i]=depth;
                        backTracking(depth,flag,n,s);
                        flag[i]=0;
                        path.remove(path.size()-1);
                    }
                }
            }
        }
    }
}


class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTrack(n, 0, chessboard);
        return res;
    }

// 另一种写法
//    public void backTrack(int n, int row, char[][] chessboard) {
//        if (row == n) {
//            res.add(Array2List(chessboard));
//            return;
//        }
//
//        for (int col = 0;col < n; ++col) {
//            if (isValid (row, col, n, chessboard)) {
//                chessboard[row][col] = 'Q';
//                backTrack(n, row+1, chessboard);
//                chessboard[row][col] = '.';
//            }
//        }
//
//    }
//
//
//    public List Array2List(char[][] chessboard) {
//        List<String> list = new ArrayList<>();
//
//        for (char[] c : chessboard) {
//            list.add(String.copyValueOf(c));
//        }
//        return list;
//    }
//
//
//    public boolean isValid(int row, int col, int n, char[][] chessboard) {
//        // 检查列
//        for (int i=0; i<row; ++i) { // 相当于剪枝
//            if (chessboard[i][col] == 'Q') {
//                return false;
//            }
//        }
//
//        // 检查45度对角线
//        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
//            if (chessboard[i][j] == 'Q') {
//                return false;
//            }
//        }
//
//        // 检查135度对角线
//        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
//            if (chessboard[i][j] == 'Q') {
//                return false;
//            }
//        }
//        return true;
//    }
//}
