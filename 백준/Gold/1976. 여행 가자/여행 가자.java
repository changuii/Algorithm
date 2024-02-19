import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())+1;
        int M = Integer.parseInt(br.readLine());
        A = new int[N];

        for(int i=1; i<N; i++){
            A[i] = i;
        }

        StringTokenizer st;
        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<N; j++){
                boolean c = st.nextToken().equals("1") ? true : false;
                if(c) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        boolean flag = true;
        for(int i=1; i<M; i++){
            if(find(target) != find(Integer.parseInt(st.nextToken())))
                flag = false;
        }

        System.out.println(flag ? "YES" : "NO");


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