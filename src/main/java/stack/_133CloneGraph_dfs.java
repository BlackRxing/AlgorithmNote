//package stack;
//
//import org.w3c.dom.Node;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//class Solution {
//    private HashMap<Node, Node> visited=new HashMap();
//    public Node cloneGraph(Node node) {
//        if(node==null){
//            return null;
//        }
//        if(visited.containsKey(node)){
//            return visited.get(node);
//        }
//        Node newnode=new Node(node.val,new ArrayList());
//        visited.put(node,newnode);
//        for(Node neighbor:node.neighbors){
//            newnode.neighbors.add(cloneGraph(neighbor));
//        }
//        return newnode;
//    }
//
//
//}
