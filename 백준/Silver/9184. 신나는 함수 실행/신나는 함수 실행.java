import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][][] map = new int[101][101][101];
    static boolean[][][] visit = new boolean[101][101][101];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while(true) {
            st  = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1) break;

            a += 50;
            b += 50;
            c += 50;

            w(a, b, c);
            sb.append(String.format(
                "w(%d, %d, %d) = %d",
                a-50, b-50, c-50, map[a][b][c]
            )).append("\n");
        }

        System.out.println(sb);
    }

    public static int w(int a, int b, int c) {
        if(visit[a][b][c]) {
           return map[a][b][c]; 
        }

        if(a - 50 <= 0 || b - 50 <= 0 || c - 50 <= 0) {
            visit[a][b][c] = true;
            map[a][b][c] = 1;
            return 1;
        }
        if(a - 50 > 20 || b - 50 > 20 || c - 50 > 20) {
            visit[a][b][c] = true;
            map[a][b][c] = w(70, 70, 70);
            return map[a][b][c];
        }
        if(a < b && b < c) {
            visit[a][b][c] = true;
            map[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            return map[a][b][c];
        }

        visit[a][b][c] = true;
        map[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        return map[a][b][c];
    }
}