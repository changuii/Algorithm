import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())+1;
        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> o1.weight-o2.weight);


        A = new int[N];
        for(int i=1; i<N; i++){
            A[i] = i;
        }
        for(int i=1; i<N; i++){
            char[] d = br.readLine().toCharArray();
            for(int j=0;j<d.length; j++){
                if(d[j] != '0') {
                    q.offer(new Edge(i, j + 1, wireLength(d[j])));
                }
            }
        }

        int answer = 0;
        int flag = 0;
        while (!q.isEmpty()){
            Edge e = q.poll();
            if(find(e.start) != find(e.destination)){
                union(e.start, e.destination);
                flag++;
            }else{
                answer += e.weight;
            }
        }

        System.out.println(flag == N-2 ? answer : -1);


    }
    static class Edge{
        int start;
        int destination;
        int weight;
        public Edge(int start, int destination, int weight){
            this.start = start;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static void union(int a, int b){
        A[find(a)] = find(b);
    }
    static int find(int a){
        if(A[a] == a) return a;
        else return A[a] = find(A[a]);
    }

    static int wireLength(char a){
        if(a >= 'a' && a <= 'z'){
            return a - 'a' + 1;
        }else if(a >= 'A' && a <= 'Z'){
            return a - 'A' + 27;
        }
        return 0;
    }

}