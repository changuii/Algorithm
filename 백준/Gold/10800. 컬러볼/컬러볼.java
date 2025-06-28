import java.util.*;
import java.lang.*;
import java.io.*;


// 지난 노드와 현재 노드가 같지 않다면
// sum에서, count[a]를 뺀 값이 정답
// 지난 노드와 현재 노드가 크기가 같다면
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Node[] nodes = new Node[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            nodes[i] = new Node(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                i,
                0, 0
            );
        }

        Arrays.sort(nodes, (o1, o2) -> {
            if(o1.b == o2.b){
                return o1.a - o2.a;
            }
            return o1.b - o2.b; 
        });

        int[] count = new int[200_001];
        int sum = nodes[0].b;
        count[nodes[0].a] = nodes[0].b;
        for(int i=1; i<nodes.length; i++){

            // 현재값과 이전값이 같은 경우
            // 현재 값은 총합 
            // - 이전에 나온 자신과 같은 공의 합
            // - 이전에 나온 같은 크기의 공의 합 (같은 색의 공은 걸러낼 수 있음)
            if(nodes[i].b == nodes[i-1].b && nodes[i].a != nodes[i-1].a){
                int currentSum = nodes[i-1].d + nodes[i-1].e;

                nodes[i].d = currentSum - count[nodes[i].a];
                nodes[i].e = count[nodes[i].a];
                sum += nodes[i].b;
                count[nodes[i].a] += nodes[i].b;
                continue;
            }
            else if(nodes[i].b == nodes[i-1].b && nodes[i].a == nodes[i].a){
                nodes[i].d = nodes[i-1].d;
                nodes[i].e = nodes[i-1].e;
                sum += nodes[i].b;
                count[nodes[i].a] += nodes[i].b;
                continue;
            }

            // 현재값과 이전값이 다른 경우
            // 현재 값은 총합 - 이전에 나온 자신과 같은 공의 합
            // sum에 값을 더해준다.
            // count에 값을 더해준다.
            nodes[i].d = sum - count[nodes[i].a]; 
            nodes[i].e = count[nodes[i].a];
            sum += nodes[i].b;
            count[nodes[i].a] += nodes[i].b;
        }

        Arrays.sort(nodes, (o1, o2) -> {
            return o1.c - o2.c;
        });

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<nodes.length; i++){
            sb.append(nodes[i].d).append("\n");
        }

        System.out.println(sb);

        
    }

    public static class Node{
        int a;
        int b;
        int c;
        int d;
        int e;

        public Node(int a, int b, int c, int d, int e){
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }

        public String toString(){
            return a + " " + b + " " + c + " " + d + " " + e;
            
        }
    }
}