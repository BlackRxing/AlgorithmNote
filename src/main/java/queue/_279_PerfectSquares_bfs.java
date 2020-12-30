package queue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _279_PerfectSquares_bfs {

        public int numSquares(int n) {
            List<Integer> squares=new ArrayList();
            Set<Integer> nums=new HashSet();
            int depth=0;
            nums.add(n);
            for(int i=1;i*i<=n;i++){
                squares.add(i*i);
            }
            while(nums.size()>0){//如果是0那么直接返回depth0
                depth++;
                Set<Integer> newnums=new HashSet();
                for(Integer num:nums){
                    for(Integer square:squares){
                        if(num.equals(square)){
                            return depth;
                        }else if(num<square){
                            break;
                        }else{
                            newnums.add(num-square);
                        }
                    }
                }
                nums=newnums;
            }

            return depth;
        }

}
