package greedy;

import java.util.Arrays;
//使用贪心算法，每次放置存量最大的那一个字母，如果已经连续放置了两个，那么就先放置存量第二大的
//使用comparable接口，构造新的类别，每次对其进行排序
public class _1405_longest_happy_string {
    class Solution {
        public String longestDiverseString(int a, int b, int c) {
            MyChar[] myChars=new MyChar[]{
                    new MyChar('a',a),
                    new MyChar('b',b),
                    new MyChar('c',c),
            };
            StringBuilder sb=new StringBuilder();
            while(true){
                Arrays.sort(myChars);
                if(sb.length()>=2&&sb.charAt(sb.length()-1)==myChars[2].ch&&sb.charAt(sb.length()-2)==myChars[2].ch){
                    if(myChars[1].count==0){
                        break;
                    }else{
                        myChars[1].count--;
                        sb.append(myChars[1].ch);
                    }
                }else{
                    if(myChars[2].count==0){
                        break;
                    }else{
                        myChars[2].count--;
                        sb.append(myChars[2].ch);
                    }
                }
            }
            return sb.toString();
        }
        private class MyChar implements Comparable{
            char ch;
            int count;
            public MyChar(char ch,int count){
                this.ch=ch;
                this.count=count;
            }
            @Override
            public int compareTo(Object o){
                MyChar other=(MyChar)o;
                return this.count-other.count;
            }
        }
    }
}
