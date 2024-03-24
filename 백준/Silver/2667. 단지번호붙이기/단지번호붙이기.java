import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int[][] A;
    static LinkedList<Integer> l;
    static int[] xValue = {0, 1, -1, 0};
    static int[] yValue = {1, 0, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())+2;
        A = new int[N][N];
        l = new LinkedList<>();
        N -= 1;

        for(int i=1; i<N; i++){
            String value = br.readLine();
            for(int j=1; j<N; j++){
                A[i][j] = Integer.parseInt(value.charAt(j-1)+"");
            }
        }
        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                int value = DFS(i, j);
                if(value != 0) l.add(value);
            }
        }

        StringBuilder sb = new StringBuilder();

        Collections.sort(l);
        sb.append(l.size()).append("\n");
        for(int i=0; i<l.size(); i++){
            sb.append(l.get(i)).append("\n");
        }
        System.out.println(sb);

    }

    public static int DFS(int x, int y){
        if(A[x][y] == 0) return 0;

        A[x][y] = 0;
        int count = 1;
        for(int i=0; i<4; i++){
            count += DFS(x + xValue[i], y + yValue[i]);
        }
        return count;
    }

}