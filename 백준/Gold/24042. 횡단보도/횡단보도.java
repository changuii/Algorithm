import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Main {
    private static int N, M;
    private static List<List<Node>> crossWalk;
    private static long[] distance;
    public static void main(String[] args) throws Exception {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 최단거리 배열
        distance = new long[N+1];
        Arrays.fill(distance, Long.MAX_VALUE);

        crossWalk = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            crossWalk.add(new ArrayList<Node>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            crossWalk.get(u).add(new Node(v, i));
            crossWalk.get(v).add(new Node(u, i));
        }
        dijkstra();
        System.out.println(distance[N]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(1, 0));
        distance[1] = 0;

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            // 현재 노드까지의 거리가 발혀진 최단 거리보다 길다면 continue
            if (currentNode.cost > distance[currentNode.index])
                continue;
            // 현재 노드부터 다른 노드 들을 순회
            for (Node next :crossWalk.get(currentNode.index)) {
                int nextIndex = next.index;
                long nextCost;
                // 현재 노드의 시간보다 다음 노드까지의 시간이 더 높으면 갱신 
                if (currentNode.cost <= next.cost) {
                    nextCost = next.cost + 1;
                // 아니라면 모듈로 연산을 통해 다음 시간을 계산
                } else {
                    // 모듈러 연산
                    nextCost = ((long) Math.ceil(((double)currentNode.cost-next.cost)/M)) * M + next.cost + 1;
                }
                // nextCost가 밝혀진 최단 거리보다 작다면 갱신
                if (nextCost < distance[nextIndex]) {
                    distance[nextIndex] = nextCost;
                    queue.offer(new Node(nextIndex, nextCost));
                }
            }
        }
    }
    
    static class Node implements Comparable<Node>{
        int index;
        long cost;
        Node(int index, long cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }
}