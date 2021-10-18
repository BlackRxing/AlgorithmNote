import java.util.List;

public class problem1 {
    public static void main(String[] args) {
        double[][] data={{5.7,0,0,0,0},{6.8,7.2,0,0,0},{6.6,5.6,6.5,0,0},{6,7,7.15,4.8,0},{6.8,7.8,7,8.25,6.3}};
        int[][] steps=new int[5][6];
        int[] step=new int[5];
        double[][] dp=new double[5][6];
        //数据初始化，j=0时dp为0，便于计算
        for(int i=0;i<5;i++){
            for(int j=1;j<6;j++) {
                dp[i][j] = data[i][j - 1];
            }
        }
        //进行动态规划的迭代过程,二维数组step记录选择的上一级项目
        for(int i=1;i<5;i++){
            for(int j=1;j<=i+1;j++) {
                if(dp[i-1][j-1]>=dp[i-1][j]){
                    steps[i][j]=j-1;
                    dp[i][j]+=dp[i-1][j-1];
                }else{
                    steps[i][j]=j;
                    dp[i][j]+=dp[i-1][j];
                }
            }
        }
        //第五级中的最大值即为最终的最大期望
        double ans=0;
        int pos=-1;
        for(int i=1;i<=5;i++){
            if(dp[4][i]>ans){
                ans=dp[4][i];
                pos=i;
            }
        }
        //从第五级到第一级依次输出选择的项目
        System.out.println("最大期望为："+ans);
        System.out.println("选择项目从后到前依次是：\n第"+pos+"项 ");
        for(int i=4;i>=1;i--){
            System.out.println("第"+steps[i][pos]+"项 ");
            pos=steps[i][pos];
        }
    }
}
