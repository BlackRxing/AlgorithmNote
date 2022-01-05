package hash;

import java.util.HashMap;

//时间复杂度为O（n^2）logm ,logm是计算最大公约数的时间，m是横坐标最大差值
public class _149_max_points_on_line {
    class Solution {
        public int maxPoints(int[][] points) {
            int result=1;
            HashMap<String,Integer> map;
            for(int i=0;i<points.length;i++){
                int max=0;
                map=new HashMap<String,Integer>();
                for(int j=i+1;j<points.length;j++){
                    int y=points[j][1]-points[i][1];
                    int x=points[j][0]-points[i][0];
                    int k=gcd(y,x);  //这里无需将xy转化为正数，比如（0 0 ，1 -1 ，-1 1）如果k都是正数，那么最后答案是2而不是3，所以k应该是有正有负的
                    String s=(y/k+"_"+x/k);
                    System.out.println(s+"");
                    int a=map.getOrDefault(s,0)+1;
                    map.put(s,a);
                    max=Math.max(max,a+1);
                }
                result=Math.max(result,max);
            }
            return result;
        }
        //会写最大公约数
        public int gcd(int a,int b){
            if(b==0){
                return a;
            }
            int temp=a;
            a=b;
            b=temp%b;
            return gcd(a,b);
        }
    }
}
