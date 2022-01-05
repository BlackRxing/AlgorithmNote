package binary_search;

public class _74_search_2D_matrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row=matrix.length,clo=matrix[0].length;
            int left=0,right=row*clo-1;
            while(left!=right){
                int mid=left+(right-left)/2;
                int midNum=matrix[mid/clo][mid%clo];
                System.out.println(left+" "+right);
                if(midNum<target){  //等于的情况放在这里只会可能过错答案
                    left=mid+1;
                }else{           //等于的情况应该收敛右侧，因为此时mid只可能等于left
                    right=mid;
                }
            }
            if(matrix[left/clo][right%clo]==target){  //这里不要并在上面一起写，因为left刚刚等于right时可能还没有对mid作比较
                return true;
            }
            return false;
        }
    }
}

//第二种写法，先找第一列，找到第一个小于等于target的那一行，然后再二分搜索那一行
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    public int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1;
        while ((high-low)>1) {     //最后可能会出现无法收敛的情况
            int mid = (high - low) / 2 + low;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if(matrix[high][0]<=target) low=high;  //防止出现high==low+1的情况
        System.out.println(low+" ");
        return low;
    }

    public boolean binarySearchRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}

