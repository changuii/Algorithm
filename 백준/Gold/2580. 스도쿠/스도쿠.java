import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] map;
    static List<int[]> list;

    static boolean[][] row;
    static boolean[][] col;
    static boolean[][][] rc;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[9][9];
        list = new ArrayList<>();

        row = new boolean[9][10];
        col = new boolean[9][10];
        rc = new boolean[3][3][10];

        for(int i=0; i<map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<map[0].length; j++) {

                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 0) {
                    list.add(new int[] {i, j});
                }
                else {
                    row[i][map[i][j]] = true;
                    col[j][map[i][j]] = true;
                    rc[i / 3][j / 3][map[i][j]] = true;
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


        int[] now = list.get(depth);
        for(int i=1; i<=9; i++) {
            if(isPossible(now[0], now[1], i)) {
                map[now[0]][now[1]] = i;
                row[now[0]][i] = true;
                col[now[1]][i] = true;
                rc[now[0] /3][now[1] /3][i] = true;

                dfs(depth + 1);

                row[now[0]][i] = false;
                col[now[1]][i] = false;
                rc[now[0] /3][now[1] /3][i] = false;
                map[now[0]][now[1]] = 0;
            }
        }
    }

    public static boolean isPossible(int x, int y, int val) {
        return !(row[x][val] || col[y][val] || rc[x / 3][y / 3][val]);
    }
}