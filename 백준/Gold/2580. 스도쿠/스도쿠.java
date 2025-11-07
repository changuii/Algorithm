import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] map;
    static List<int[]> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[9][9];
        list = new ArrayList<>();

        for(int i=0; i<map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<map[0].length; j++) {

                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 0) {
                    list.add(new int[] {i, j});
                }
            }
        }

        dfs(0);
    }


    public static void dfs(int depth) {
        if(depth == list.size()) {
            StringBuilder sb = new StringBuilder() ;
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }

            System.out.println(sb);
            System.exit(0);
        }


        for(int i=1; i<=9; i++) {
            int[] now = list.get(depth);

            if(isPossible(now[0], now[1], i)) {
                map[now[0]][now[1]] = i;
                dfs(depth + 1);
                map[now[0]][now[1]] = 0;
            }
        }
    }

    public static boolean isPossible(int x, int y, int val) {
        for(int i=0; i<9; i++) {
            if(map[x][i] == val) return false;
        }

        for(int i=0; i<9; i++) {
            if(map[i][y] == val) return false;
        }

        int mx = (x / 3) * 3;
        int my = (y / 3) * 3;
        for(int i=mx; i < mx + 3; i++ ){
            for(int j=my; j < my + 3; j++ ){
                if(map[i][j] == val) return false;
            }
        }

        return true;
    }
}