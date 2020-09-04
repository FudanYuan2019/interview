package base.graph;

import java.util.*;

/**
 * @Author: Jeremy
 * @Date: 2019/12/23 10:52
 */
public class MaxNetworkDelay {
    public int[] delays;

    public int networkDelayTimeWithDFS(int[][] times, int N, int K) {
        // 构造邻接列表
        LinkedList<ArrayList<Integer>>[] edgeLink = new LinkedList[N];
        for (int i = 0; i < times.length; i++) {
            int s = times[i][0] - 1;
            int e = times[i][1] - 1;
            int w = times[i][2];
            if (edgeLink[s] == null) {
                edgeLink[s] = new LinkedList<>();
            }
            ArrayList<Integer> tuple = new ArrayList<>(2);
            tuple.add(e);
            tuple.add(w);
            edgeLink[s].add(tuple);
        }

        // 初始化延迟时间
        delays = new int[N];
        Arrays.fill(delays, Integer.MAX_VALUE);

        // 深度优先遍历图
        dfs(K - 1, 0, edgeLink);

        System.out.println(Arrays.toString(delays));

        // 返回延迟最大值
        int maxDelay = 0;
        for (int delay : delays) {
            if (delay == Integer.MAX_VALUE) {
                return -1;
            }
            if (delay > maxDelay) {
                maxDelay = delay;
            }
        }
        return maxDelay;
    }

    public void dfs(int id, int time, LinkedList<ArrayList<Integer>>[] edgeLink) {
        System.out.println((id + 1) + " " + time);
        if (delays[id] <= time) {
            return;
        }
        delays[id] = time;
        if (edgeLink[id] == null) {
            return;
        }
        for (int i = 0; i < edgeLink[id].size(); i++) {
            ArrayList<Integer> tuple = edgeLink[id].get(i);
            int e = tuple.get(0);
            int w = tuple.get(1);
            dfs(e, time + w, edgeLink);
        }
    }

    public int networkDelayTimeWithDijkstra(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        heap.offer(new int[]{0, K});

        Map<Integer, Integer> dist = new HashMap<>();
        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int d = info[0], node = info[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, d);
            if (graph.containsKey(node))
                for (int[] edge : graph.get(node)) {
                    int nei = edge[0], d2 = edge[1];
                    if (!dist.containsKey(nei))
                        heap.offer(new int[]{d + d2, nei});
                }
        }

        if (dist.size() != N) return -1;
        int ans = 0;
        for (int cand : dist.values())
            ans = Math.max(ans, cand);
        return ans;
    }

    public static void main(String[] args) {
        MaxNetworkDelay maxNetworkDelay = new MaxNetworkDelay();
//        int N = 4;
//        int[][] times = new int[3][];
//        times[0] = new int[]{2, 1, 1};
//        times[1] = new int[]{2, 3, 1};
//        times[2] = new int[]{3, 4, 1};
//        int K = 2;

//        int N = 2;
//        int[][] times = new int[2][];
//        times[0] = new int[]{1, 2, 1};
//        times[1] = new int[]{2, 1, 3};
//        int K = 2;

        int N = 3;
        int[][] times = new int[3][];
        times[0] = new int[]{1, 2, 1};
        times[1] = new int[]{2, 3, 2};
        times[2] = new int[]{1, 3, 2};
        int K = 1;
        int maxDelay = maxNetworkDelay.networkDelayTimeWithDFS(times, N, K);
        int maxDelay2 = maxNetworkDelay.networkDelayTimeWithDijkstra(times, N, K);
        System.out.println("最大延迟: " + maxDelay);
        System.out.println("最大延迟: " + maxDelay2);
    }
}
