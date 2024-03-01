import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())+1;

        A = new int[N];
        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

        for(int i=1; i<N; i++){
            A[i] = i;
        }

        for(int i=1; i<N; i++){
            char[] data = br.readLine().toCharArray();
            for(int j=0; j<N-1; j++){
                if(data[j] != '0'){
                    q.offer(
                            new Edge(i, j+1, lanLength(data[j])));
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
            this.weight =weight;
        }
    }



    public static void union(int a, int b){
        A[find(a)] = find(b);
    }
    public static int find(int a){
        if(A[a] == a) return a;
        else return A[a] = find(A[a]);
    }

    public static int lanLength(char x){
        if(x == '0') return 0;
        char[] data = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for(int i=1; i<53; i++){
            if(i < 27 && x == data[i-1])
                return i;
            else if(i > 26 && x == Character.toUpperCase(data[i-27]))
                return i;
        }
        return 0;
    }


}