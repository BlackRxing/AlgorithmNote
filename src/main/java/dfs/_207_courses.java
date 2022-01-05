package dfs;
//使用listlist储存拓扑结构，深度遍历或广度遍历判断是否有回环
public class _207_courses {
    class Solution {
        boolean result=true;
        int[] state;
        List<List<Integer>> topo;
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            state=new int[numCourses];
            topo=new ArrayList();
            for(int i=0;i<numCourses;i++){
                topo.add(new ArrayList<Integer>());
            }
            for(int[] i:prerequisites){
                topo.get(i[1]).add(i[0]);
            }
            for(int i=0;i<numCourses;i++){
                if(state[i]==0){
                    dfs(i);
                }
            }
            return result;
        }
        private void dfs(int i ){
            if(result==false) return;
            if(state[i]==1){
                result=false;
                return;
            }
            state[i]=1;
            for(int x : topo.get(i)){
                if(state[x]!=2){
                    dfs(x);
                }
            }
            state[i]=2;
        }
    }
}
