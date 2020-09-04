package base.graph;

import java.util.*;

/**
 * @Author: Jeremy
 * @Date: 2020/2/18 15:44
 */
public class DAG2 {
    class Node {
        String val;
        List<DAG2.Node> parents;

        public Node(String val) {
            this.val = val;
            this.parents = new ArrayList<>();
        }

        public void addParent(DAG2.Node node) {
            this.parents.add(node);
        }
    }

    private Set<String> visited;

    public DAG2() {
        visited = new HashSet<>();
    }

    public void core(DAG2.Node root) {
        if (root == null || visited.contains(root.val)) {
            return;
        }
        for (int i = 0; i < root.parents.size(); i++) {
            core(root.parents.get(i));
        }
        if (!visited.contains(root.val)) {
            System.out.print(root.val);
            visited.add(root.val);
        }
    }

    public static void main(String[] args) {
        DAG2 dag = new DAG2();
        DAG2.Node a = dag.new Node("A");
        DAG2.Node b = dag.new Node("B");
        DAG2.Node c = dag.new Node("C");
        DAG2.Node d = dag.new Node("D");
        DAG2.Node e = dag.new Node("E");
        DAG2.Node f = dag.new Node("F");
        a.addParent(b);
        a.addParent(c);
        b.addParent(d);
        c.addParent(d);
        d.addParent(e);
        e.addParent(f);
        a.addParent(f);
        dag.core(a);
    }
}
