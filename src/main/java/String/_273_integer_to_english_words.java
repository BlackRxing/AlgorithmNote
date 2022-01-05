package String;

public class _273_integer_to_english_words {
    class Solution {
        String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousands = {"", "Thousand", "Million", "Billion"};

        public String numberToWords(int num) {
            if (num == 0) {
                return "Zero";
            }
            StringBuffer sb = new StringBuffer();
            //这一步很关键，从前往后处理
            for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
                int curNum = num / unit;
                if (curNum != 0) {  //如果是0就不需要thousand，million之类的
                    num -= curNum * unit;
                    recursion(sb, curNum);
                    sb.append(thousands[i]).append(" ");
                }
            }
            return sb.toString().trim();
        }
        //需要用到迭代，相比于递归不会产生多余的空格
        public void recursion(StringBuffer curr, int num) {
            if (num == 0) {   //使用递归可以减少代码量
                return;
            } else if (num < 10) {
                curr.append(singles[num]).append(" ");
            } else if (num < 20) {
                curr.append(teens[num - 10]).append(" ");
            } else if (num < 100) {
                curr.append(tens[num / 10]).append(" ");
                recursion(curr, num % 10);
            } else {
                curr.append(singles[num / 100]).append(" Hundred ");
                recursion(curr, num % 100);
            }
        }
    }
}

//我的写法，需要修改更多，效率不高
class Solution {
    private String[] terms=new String[]{"","Thousand","Million","Billion"};
    private String[] numbers=new String[]{"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    private String[] tennumbers=new String[]{"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private String[] abovetennumbers=new String[]{"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        String result=convert(num,0,"");
        if(num==0){
            return "Zero";
        }
        return result.trim();
    }
    public String convert(int num,int depth,String temp){
        if(num==0){
            return temp;
        }
        String result="";
        int tempNum=num%1000;
        if(tempNum==0){
            return convert(num/1000,++depth,result+temp);
        }
        if(tempNum>=100){
            result+=numbers[tempNum/100]+" "+"Hundred"+" ";
            tempNum=tempNum%100;
        }
        if(tempNum>=10&&tempNum<=19){
            result+=tennumbers[tempNum%10]+" ";
        }else if(tempNum>=20){
            result+=abovetennumbers[tempNum/10]+" ";
            if(tempNum%10!=0){
                result+=numbers[tempNum%10]+" ";
            }
        }else if(tempNum>0){
            result+=numbers[tempNum]+" ";
        }else{

        }
        result+=terms[depth]+" ";
        return convert(num/1000,++depth,result+temp);
    }
}