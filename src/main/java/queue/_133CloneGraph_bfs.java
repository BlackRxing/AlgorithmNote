//class Solution {
//    public Node cloneGraph(Node node) {
//        if(node==null){
//            return null;
//        }
//        HashMap<Node,Node> visited=new HashMap();
//        Queue<Node> nodequeue=new LinkedList();
//        nodequeue.add(node);
//        visited.put(node,new Node(node.val,new ArrayList()));
//        while(!nodequeue.isEmpty()){
//            Node thisnode=nodequeue.poll();
//            for(Node neighbor:thisnode.neighbors){
//                if(!visited.containsKey(neighbor)){
//                    visited.put(neighbor,new Node(neighbor.val,new ArrayList()));
//                    nodequeue.offer(neighbor);
//                }
//                visited.get(thisnode).neighbors.add(visited.get(neighbor));
//            }
//        }
//        return visited.get(node);
//    }
//}