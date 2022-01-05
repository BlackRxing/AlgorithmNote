package String;

public class _8_atoi {
    class Solution {
        public int myAtoi(String s) {
            //用来标记是否为负数
            int flag = 0;
            char[] c = s.toCharArray();
            //res记录答案，last用来判断是否越界
            int res = 0, last = 0;
            //count用来记录遍历到哪一位
            int count = 0;
            //1、去掉前面的空格
            while (count < c.length){
                if (c[count] == ' ') count++;
                else break;
            }
            //2、查看是否有正负号
            if (count < c.length && c[count] == '-'){
                flag = 1;
                count++;
            }else if (count < c.length && c[count] == '+'){
                count++;
            }
            //3、处理数字
            while (count < c.length){
                //如果是数字，更新res
                if (c[count] >= '0' && c[count] <= '9'){
                    last = res;
                    res = res * 10 + (c[count] - '0');
                    //当res / 10 != last，证明res越界了，根据正负号，返回最大或最小值
                    if (res / 10 != last){
                        return flag == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }
                }else break;//如果不是数字，跳出循环
                count++;
            }
            //根据正负号返回结果
            return flag == 1 ? -res : res;

        }
    }

}
