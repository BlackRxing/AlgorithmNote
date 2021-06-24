package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

////方法1：排序，索引
//public class _49_group_anagrams {
//    class Solution {
//        public List<List<String>> groupAnagrams(String[] strs) {
//            Map<String,List<String>> map=new HashMap<String,List<String>>();
//            for(String str : strs){
//                char[] array=str.toCharArray();
//                Arrays.sort(array);
//                String key=new String(array);
//                List<String> list=map.getOrDefault(key,new ArrayList<String>());
//                list.add(str);
//                map.put(key,list);
//            }
//            return new ArrayList<List<String>>(map.values());
//        }
//    }
//}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<String,List<String>>();
        for(String str : strs){
            char[] array=str.toCharArray();
            int[] counts=new int[26];
            for(char c:array){
                counts[c-'a']+=1;
            }
            StringBuffer sb=new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key=sb.toString();
            List<String> list=map.getOrDefault(key,new ArrayList<String>()); //getordefault写起来更简洁
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());  //map.values返回的时Collections<List<String>>
    }
}