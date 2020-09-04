package base.graph;

import java.util.LinkedList;

/**
 * @Author: Jeremy
 * @Date: 2019/12/28 10:50
 */
public class ShortestPath {
    public int vertex;
    public LinkedList<Edge>[] linkedEdge;

    public ShortestPath(int vertex, int[][] matrix) {
        this.vertex = vertex;
        linkedEdge = new LinkedList[vertex];
        for (int i = 0; i < matrix.length; i++) {
            int s = matrix[i][0] - 1;
            int e = matrix[i][1] - 1;
            int w = matrix[i][2];
            if (linkedEdge[s] == null) {
                linkedEdge[s] = new LinkedList<>();
            }
            linkedEdge[s].add(new Edge(s, e, w));
        }
    }

    /**
     * 记录起点至某顶点的距离
     */
    static class Vertex {
        public int vertex;  // 顶点编号
        public int distance;  // 到该顶点的距离

        public Vertex(int vertex) {
            this.vertex = vertex;
            this.distance = Integer.MAX_VALUE;
        }

        public Vertex(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    /**
     * 边
     */
    static class Edge {
        public int sVertex;     // 起始顶点
        public int eVertex;     // 终止顶点
        public int weight;      // 权重

        public Edge(int sVertex, int eVertex, int weight) {
            this.sVertex = sVertex;
            this.eVertex = eVertex;
            this.weight = weight;
        }
    }

    /**
     * 优先级队列，小顶堆
     */
    static class VertexPriorityQueue {
        public Vertex[] vertices;
        public int size;
        public int count;

        public VertexPriorityQueue(int size) {
            this.size = size;
            this.vertices = new Vertex[size];
            this.count = 0;
        }

        public VertexPriorityQueue(int size, Vertex[] vertices) {
            this.size = size;
            this.vertices = new Vertex[size];
            for (int i = 0; i < vertices.length; i++) {
                this.vertices[i] = vertices[i];
            }
            update();
            this.count = vertices.length;
        }

        /**
         * 增加元素至小顶堆
         *
         * @param vertex
         * @return
         */
        public boolean add(Vertex vertex) {
            if (count >= size) {
                return false;
            }
            vertices[count++] = vertex;
            update();
            return true;
        }

        /**
         * 更新优先级队列
         *
         * @return
         */
        public void update() {
            for (int i = count / 2; i >= 0; i--) {
                heapify(i);
            }
        }

        /**
         * 更新
         *
         * @param vertex
         */
        public void update(Vertex vertex) {
            for (int i = 0; i < count; i++) {
                if (vertices[i].vertex == vertex.vertex) {
                    vertices[i].distance = vertex.distance;
                    break;
                }
            }
            update();
        }

        /**
         * 弹出堆顶元素
         *
         * @return
         */
        public Vertex poll() {
            if (isEmpty()) {
                return null;
            }
            swap(vertices, 0, --count);
            update();
            return vertices[count];
        }

        /**
         * 优先级队列是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return this.count == 0;
        }

        /**
         * 堆化
         *
         * @param i
         */
        public void heapify(int i) {
            while (true) {
                int minPos = i;
                if (2 * i + 1 < count && vertices[2 * i + 1].distance < vertices[i].distance) minPos = 2 * i + 1;
                if (2 * i + 2 < count && vertices[2 * i + 2].distance < vertices[minPos].distance) minPos = 2 * i + 2;
                if (minPos == i) {
                    break;
                }
                swap(vertices, i, minPos);
                i = minPos;
            }
        }

        /**
         * 交换
         *
         * @param vertices
         * @param i
         * @param j
         */
        public void swap(Vertex[] vertices, int i, int j) {
            Vertex temp = vertices[i];
            vertices[i] = vertices[j];
            vertices[j] = temp;
        }

        public void print() {
            for (int i = 0; i < count; i++) {
                System.out.print("(" + vertices[i].vertex + " " + vertices[i].distance + ")" + "->");
            }
            System.out.println();
        }
    }

    /**
     * 最短距离
     *
     * @return
     */
    public int dijkstra(int start, int end) {
        // 初始化从起点到各顶点的最小距离
        Vertex[] vertexes = new Vertex[vertex];
        for (int i = 0; i < this.vertex; ++i) {
            vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        // 记录某顶点是否在优先级队列中
        boolean[] inQueue = new boolean[vertex];

        // 将起点加入优先级队列
        VertexPriorityQueue queue = new VertexPriorityQueue(vertex);
        vertexes[start].distance = 0;
        queue.add(vertexes[start]);
        inQueue[start] = true;

        // 记录最短路径
        int[] preVertex = new int[vertex];
        while (!queue.isEmpty()) {
            Vertex minVertex = queue.poll();
            if (minVertex.vertex == end) {
                break;
            }
            for (int i = 0; i < linkedEdge[minVertex.vertex].size(); i++) {
                Edge edge = linkedEdge[minVertex.vertex].get(i);
                Vertex nextVertex = vertexes[edge.eVertex];
                if (minVertex.distance + edge.weight < nextVertex.distance) {
                    nextVertex.distance = minVertex.distance + edge.weight;
                    preVertex[nextVertex.vertex] = minVertex.vertex;
                    if (inQueue[nextVertex.vertex]) {
                        queue.update(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inQueue[nextVertex.vertex] = true;
                    }
                }
            }
        }
        printShortestPath(preVertex, start, end);
        return vertexes[end].distance;
    }

    public void printShortestPath(int[] preVertex, int start, int end) {
        System.out.print(start);
        core(preVertex, start, end);
        System.out.println();
    }

    public void core(int[] preVertex, int s, int t) {
        if (s == t) {
            return;
        }
        core(preVertex, s, preVertex[t]);
        System.out.print("->" + t);
    }

    public static void main(String[] args) {
        int vertex = 6;
        int[][] matrix = new int[8][];
        matrix[0] = new int[]{1, 2, 10};
        matrix[1] = new int[]{2, 3, 15};
        matrix[2] = new int[]{2, 4, 2};
        matrix[3] = new int[]{3, 6, 5};
        matrix[4] = new int[]{4, 3, 1};
        matrix[5] = new int[]{4, 6, 12};
        matrix[6] = new int[]{1, 5, 15};
        matrix[7] = new int[]{5, 6, 10};
        ShortestPath shortestPath = new ShortestPath(vertex, matrix);
        int distance = shortestPath.dijkstra(0, 5);
        System.out.println("最短路径：" + distance);
    }
}
