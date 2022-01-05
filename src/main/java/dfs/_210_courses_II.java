package dfs;
//在207的基础上加一个stack即可
public class _210_courses_II {
    class Solution {
        boolean result=true;
        int[] state;
        List<List<Integer>> topo;
        Stack<Integer> stack=new Stack();
        public int[] findOrder(int numCourses, int[][] prerequisites) {
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
            int[] ans=new int[0];
            if(!result){
                return ans;
            }else{
                int i=0;
                ans=new int[numCourses];
                while(!stack.isEmpty()){
                    ans[i]=stack.pop();
                    i++;
                }
            }
            return ans;
        }
        private void dfs(int i){
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
            stack.push(i);
            state[i]=2;
        }
    }
}
