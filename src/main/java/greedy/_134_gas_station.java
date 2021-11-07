package greedy;
//问题1：随着j增大，当sum[i,j]第一次<0时，任意x在ij之间，【x，j】也小于0，可以反证
//问题2：当sum>0时，一定存在至少一点满足条件 ：【i,j】是i开始第一次出现负数，总和是正数所以【j+1,i】一定是正数，而且i，j-1一定是正数（因为j是第一次出现），所以从j出发一定没错
public class _134_gas_station {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int max=0;
            int curmax=0;
            int pos=0;
            for(int i=0;i<gas.length;i++){
                max+=gas[i]-cost[i];
                curmax+=gas[i]-cost[i];
                if(curmax<0){
                    curmax=0;
                    pos=(i+1)%gas.length;
                }
            }
            if(max<0) return-1;
            return pos;
        }
    }
}
