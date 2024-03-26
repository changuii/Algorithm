import java.util.*;


class Main {
    static ArrayList<Integer>[] A;
    static int[] answer;
    public static void main(String[] args) throws Exception {
        

        int N = read()+1;
        A = new ArrayList[N];
        answer = new int[N];
        for(int i=1; i<N; i++){
            A[i] = new ArrayList<>();
        }

        for(int i=1; i<N-1; i++){
            int a= read();
            int b = read();

            A[a].add(b);
            A[b].add(a);
        }
        DFS(1);

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<N; i++){
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);

    }
    static void DFS(int a){
        for(int x : A[a]){
            if(answer[x] == 0){
                answer[x] = a;
                DFS(x);
            }
        }
    }
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

}