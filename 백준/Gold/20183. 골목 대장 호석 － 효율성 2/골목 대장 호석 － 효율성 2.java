import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        ArrayList<ArrayList<int[]>> list = new ArrayList<>();

        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(a).add(new int[]{b, w});
            list.get(b).add(new int[]{a, w});
        }


        long l = 0;
        long h = Integer.MAX_VALUE;
        long mid = 0;

        long[] distance;
        while (l<=h) {
            mid = (l + h) / 2;

            distance = dijkstra(list, A, N, mid, C);

            // System.out.println(mid + " : " + distance[B]);
            if(distance[B] != Long.MAX_VALUE){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        System.out.println(h == Integer.MAX_VALUE ? -1 : h+1);
    }
    
    public static long[] dijkstra(ArrayList<ArrayList<int[]>> list, int start, int N, long shame, long C){
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) ->{
           return Long.compare(o1.weight, o2.weight); 
        });

        boolean[] visit = new boolean[N+1];
        
        long[] distance= new long[N+1];
        for(int i=1; i<=N; i++){
            distance[i] = Long.MAX_VALUE;
        }
        
        q.offer(new Node(start, 0));
        distance[start] = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();

            if(visit[now.index]) continue;
            visit[now.index] = true;
            
            for(int[] next : list.get(now.index)){
                if(next[1] > shame || next[1] + now.weight > C) continue;
                
                if(next[1] + now.weight < distance[next[0]]){
                    distance[next[0]] = distance[now.index] + next[1];
                    q.offer(new Node(next[0], distance[next[0]]));
                }
            }
        }

        return distance;
    }

    public static class Node{
        int index;
        long weight;

        public Node(int index, long weight){
            this.index=index;
            this.weight=weight;
        }
    }

}