import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

    static int[] A ;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken());

        A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");

            boolean control = Integer.parseInt(st.nextToken())== 1 ? true : false;
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(control){
                sb.append(find(a) == find(b) ? "YES" : "NO").append("\n");
            }
            else{
                union(a, b);
            }
        }
        System.out.println(sb);
    }

    static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        A[y] = x;
    }

    static int find(int a){
        if(A[a] == a){
            return a;
        }else{
            A[a] = find(A[a]);
            return A[a];
        }
    }
}