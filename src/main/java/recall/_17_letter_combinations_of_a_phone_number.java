package recall;

import java.util.ArrayList;
import java.util.List;

public class _17_letter_combinations_of_a_phone_number {
    class Solution {
        List<String> list=new ArrayList();
        StringBuilder temp=new StringBuilder();
        public List<String> letterCombinations(String digits) {
            if(digits==null||digits.length()==0){
                return list;
            }
            String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; //数据类型要会选
            backtracing(digits,numString,1);
            return list;
        }
        public void backtracing(String digits,String[] numString,int pos){
            if(pos-1==digits.length()){
                list.add(temp.toString());
                return;
            }
            String letters=numString[digits.charAt(pos-1)-'0'];

            for(int i=0;i<letters.length();i++){
                temp.append(letters.charAt(i));
                backtracing(digits,numString,pos+1);
                temp.deleteCharAt(temp.length()-1);
            }
        }

    }
}
