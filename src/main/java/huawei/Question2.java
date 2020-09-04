package huawei;

import java.util.*;

/**
 * @Author: Jeremy
 * @Date: 2020/9/2 19:01
 */
public class Question2 {
    private static class Node {
        private int x;
        private int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int[][] visited;
    private static int[] X = new int[]{1, -1, 0, 0};
    private static int[] Y = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(",");
        int M = Integer.parseInt(str[0]);
        int N = Integer.parseInt(str[1]);
        char[][] matrix = new char[M][N];

        for (int i = 0; i < M; i++) {
            char[] chars = scanner.next().toCharArray();
            matrix[i] = chars;
        }

        visited = new int[M][N];
        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 'S' && visited[i][j] == 0) {
                    res++;
                    bfs(matrix, M, N, i, j);
                }
            }
        }

        System.out.println(res);
    }

    private static void bfs(char[][] matrix, int M, int N, int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        visited[x][y] = 1;
        queue.offer(new Node(x, y));
        while (!queue.isEmpty()) {
            Node top = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = top.x + X[i];
                int newY = top.y + Y[i];
                if (check(newX, newY, matrix, M, N)) {
                    Node node = new Node(newX, newY);
                    queue.offer(node);
                    visited[newX][newY] = 1;
                }
            }
        }
    }

    private static boolean check(int x, int y, char[][] matrix, int M, int N) {
        if (x >= M || y >= N || x < 0 || y < 0) {
            return false;
        }
        if (matrix[x][y] == 'H' || visited[x][y] == 1) {
            return false;
        }
        return true;
    }

}

//4,5
//HSHHH
//SSHHH
//HHSHH
//HHHSS