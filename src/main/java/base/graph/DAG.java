package base.graph;

import java.util.*;

/**
 * @Author: Jeremy
 * @Date: 2020/2/17 17:52
 */
public class DAG {
    class Node{
        String val;
        List<Node> children;
        public Node(String val){
            this.val = val;
            this.children = new ArrayList<>();
        }

        public void addChild(Node node){
            this.children.add(node);
        }
    }

    private Stack<String> stack;
    private Set<String> visited;

    public DAG(){
        stack = new Stack<>();
        visited = new HashSet<>();
    }

    public void core(Node root){
        if (root == null || visited.contains(root.val)){
            return;
        }
        for (int i = 0; i < root.children.size(); i++){
            core(root.children.get(i));
        }
        if (!visited.contains(root.val)){
            stack.push(root.val);
            visited.add(root.val);
        }
    }

    public String topoTraverse(Node root){
        core(root);
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        DAG dag = new DAG();
        Node a = dag.new Node("A");
        Node b = dag.new Node("B");
        Node c = dag.new Node("C");
        Node d = dag.new Node("D");
        Node e = dag.new Node("E");
        Node f = dag.new Node("F");
        a.addChild(b);
        a.addChild(c);
        b.addChild(d);
        c.addChild(d);
        d.addChild(e);
        e.addChild(f);
        a.addChild(f);

        System.out.println(dag.topoTraverse(a));
    }
}
