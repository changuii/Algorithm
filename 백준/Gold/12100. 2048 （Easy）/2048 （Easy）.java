import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] map;
    static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        map = new int[N][N];
        max = 0;

        for(int i=0; i<N; i++) {
             st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);

    }

    public static void dfs(int depth) {
        if(depth == 5) {
            int m = 0;

            for(int i=0; i<map.length; i++) {
                for(int j=0; j<map.length; j++) {
                    m = Math.max(m, map[i][j]);
                }
            }
            max = Math.max(max, m);
            return;
        }

        for(int k=0; k<4; k++) {
            int[][] before = new int[map.length][map.length];
            for(int i=0; i<map.length; i++) {
                for(int j=0; j<map.length; j++) {
                    before[i][j] = map[i][j];
                }
            }
            oper(k);
            dfs(depth + 1);
            map = before;
        }
        
    }


    public static void oper(int dir) {
        // 상
        if(dir == 0) {
            for(int j=0; j<map.length; j++) {

                for(int i=0; i<map.length; i++) {

                    for(int k=i+1; k<map.length; k++) {
                        if(map[i][j] == 0 && map[k][j] > 0){
                            map[i][j] = map[k][j];
                            map[k][j] = 0;
                        }
                        else if(map[i][j] > 0 && map[i][j] == map[k][j]){
                            map[i][j] *= 2;
                            map[k][j] = 0;
                            break;
                        } else if(map[i][j] > 0 && map[k][j] != 0) {
                            break;
                        }
                    }
                }
            }
            
            return;
        }

        // 하
        if(dir == 1) {
            for(int j=0; j<map.length; j++) {

                for(int i=map.length-1; i>=0; i--){

                    for(int k=i-1; k>=0; k--) {
                        if(map[i][j] == 0 && map[k][j] > 0){
                            map[i][j] = map[k][j];
                            map[k][j] = 0;
                        }
                        else if(map[i][j] > 0 && map[i][j] == map[k][j]){
                            map[i][j] *= 2;
                            map[k][j] = 0;
                            break;
                        } else if(map[i][j] > 0 &&  map[k][j] != 0) {
                            break;
                        }
                    }
                }
            }

            return;
        }

        // 좌
        if(dir == 2) {

            for(int i=0; i<map.length; i++) {

                for(int j=0; j<map.length; j++) {

                    for(int k=j+1; k<map.length; k++) {
                        if(map[i][j] == 0 && map[i][k] > 0) {
                            map[i][j] = map[i][k];
                            map[i][k] = 0;
                        } else if(map[i][j] > 0 && map[i][j] == map[i][k]) {
                            map[i][j] *= 2;
                            map[i][k] = 0;
                            break;
                        } else if(map[i][j] > 0 && map[i][k] != 0) {
                            break;
                        }
                    }
                }
            }
            
            return;
        }

        // 우
        if(dir == 3) {
            for(int i=0; i<map.length; i++) {

                for(int j=map.length-1; j>=0; j--) {

                    for(int k=j-1; k>=0; k--) {
                        if(map[i][j] == 0 && map[i][k] > 0) {
                            map[i][j] = map[i][k];
                            map[i][k] = 0;
                        } else if(map[i][j] > 0 && map[i][j] == map[i][k]) {
                            map[i][j] *= 2;
                            map[i][k] = 0;
                            break;
                        } else if(map[i][j] > 0 && map[i][k] != 0) {
                            break;
                        } 
                    }
                }
            }
        }
    }
}