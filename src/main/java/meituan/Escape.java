package meituan;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author: Jeremy
 * @Date: 2020/8/29 17:12
 */
public class Escape {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int[][] links = new int[n][n];
            in.nextLine();
            while (in.hasNextLine()) {
                String[] s = in.nextLine().split(" ");
                if (s.length != 2) {
                    break;
                }
                int id1 = Integer.parseInt(s[0]);
                int id2 = Integer.parseInt(s[1]);
                links[id1 - 1][id2 - 1] = 1;
            }

            Graph graph = new Graph(n, links);
            graph.printEdgesLink();
        }
    }
}


class Graph {
    public int vertex;  // 顶点个数
    public LinkedList<Integer>[] edgesLink;  // 邻接列表
    public LinkedList<Integer>[] inverseEdgesLink;  // 逆邻接列表
    public int[] visited; // 访问矩阵

    public Graph(int vertex, int[][] edges) {
        this.vertex = vertex;
        this.edgesLink = new LinkedList[vertex];
        this.inverseEdgesLink = new LinkedList[vertex];
        this.visited = new int[vertex];
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                if (edges[i][j] == 1) {
                    if (edgesLink[i] == null) {
                        edgesLink[i] = new LinkedList<>();
                    }
                    edgesLink[i].add(j);

                    if (inverseEdgesLink[j] == null) {
                        inverseEdgesLink[j] = new LinkedList<>();
                    }
                    inverseEdgesLink[j].add(i);
                }
            }
        }
    }

    public void printEdgesLink() {
        for (int i = 0; i < vertex; i++) {
            System.out.print((i + 1) + "->");
            if (edgesLink[i] == null) {
                System.out.println("^");
                continue;
            }
            for (int j = 0; j < edgesLink[i].size(); j++) {
                System.out.print((edgesLink[i].get(j) + 1) + "->");
            }
            System.out.println("^");
        }
        System.out.println();
    }

    public void printInverseEdgesLink() {
        for (int i = 0; i < vertex; i++) {
            if (inverseEdgesLink[i] == null) {
                System.out.println((i + 1));
                continue;
            }
            for (int j = 0; j < inverseEdgesLink[i].size(); j++) {
                System.out.print((inverseEdgesLink[i].get(j) + 1) + ", ");
            }
            System.out.println(" -> " + (i + 1));
        }
        System.out.println();
    }

    public void traverse() {
        visited = new int[5];
        for (int i = 0; i < vertex; i++) {
            DFS(i, edgesLink);
        }
        System.out.println();

        visited = new int[5];
        for (int i = 0; i < vertex; i++) {
            BFS(i);
        }
        System.out.println();
    }

    public void DFS(int vertex, LinkedList<Integer>[] edgesLink) {
        if (visited[vertex] == 1) {
            return;
        }
        visited[vertex] = 1;
        if (edgesLink[vertex] == null) {
            return;
        }
        for (int j = 0; j < edgesLink[vertex].size(); j++) {
            int w = edgesLink[vertex].get(j);
            if (visited[w] == 1) continue;
            DFS(w, edgesLink);
        }
    }

    public void DFS(int vertex, LinkedList<Integer>[] edgesLink, boolean inverse) {
        if (visited[vertex] == 1) {
            return;
        }
        if (!inverse){
            System.out.print((vertex + 1) + " ");
        }
        visited[vertex] = 1;
        if (edgesLink[vertex] == null) {
            if (inverse){
                System.out.print((vertex + 1) + " ");
            }
            return;
        }
        for (int j = 0; j < edgesLink[vertex].size(); j++) {
            int w = edgesLink[vertex].get(j);
            if (visited[w] == 1) continue;
            DFS(w, edgesLink, inverse);
        }
        if (inverse){
            System.out.print((vertex + 1) + " ");
        }
    }

    public void BFS(int vertex) {
        if (visited[vertex] == 1) {
            return;
        }
        System.out.print((vertex + 1) + " ");
        visited[vertex] = 1;
        if (edgesLink[vertex] == null) {
            return;
        }
        for (int j = 0; j < edgesLink[vertex].size(); j++) {
            int w = edgesLink[vertex].get(j);
            if (visited[w] == 1) continue;
            System.out.print((w + 1) + " ");
            visited[w] = 1;
        }
    }

    public void topoSortByKahn() {
        int[] inDegree = new int[vertex];
        for (int i = 0; i < vertex; i++) {
            if (edgesLink[i] == null) {
                continue;
            }
            for (int j = 0; j < edgesLink[i].size(); j++) {
                int w = edgesLink[i].get(j);
                inDegree[w]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertex; ++i) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int i = queue.poll();
            System.out.print((i + 1) + " ");
            if (edgesLink[i] == null) {
                continue;
            }
            for (int j = 0; j < edgesLink[i].size(); j++) {
                int w = edgesLink[i].get(j);
                inDegree[w]--;
                if (inDegree[w] == 0) {
                    queue.add(w);
                }
            }
        }
        System.out.println();
    }

    public void topoSortByDFS() {
        visited = new int[5];
        for (int i = 0; i < vertex; i++) {
            DFS(i, inverseEdgesLink, true);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int v = 5;
        int[][] edges = new int[v][v];
        edges[0][1] = 1;
        edges[0][3] = 1;
        edges[1][2] = 1;
        edges[1][4] = 1;
        edges[3][2] = 1;
        edges[3][4] = 1;
        Graph graph = new Graph(v, edges);
        graph.printEdgesLink();
        graph.printInverseEdgesLink();
        graph.traverse();
        graph.topoSortByKahn();
        graph.topoSortByDFS();
    }
}
