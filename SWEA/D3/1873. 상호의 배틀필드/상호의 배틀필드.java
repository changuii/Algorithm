import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[] tankDirection = {'^', '>', 'v', '<'};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char[][] map = new char[N][M];
            int x = 0;
            int y = 0;
            int direction = 0;
            for(int i=0; i<N; i++){
                char[] value = br.readLine().toCharArray();
                for(int j=0; j<M; j++){
                    map[i][j] = value[j];
                    if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>' || map[i][j] == '<'){
                        x = i;
                        y = j;
                        if(map[i][j] == '^') direction = 0;
                        else if(map[i][j] == '>') direction = 1;
                        else if(map[i][j] == 'v') direction = 2;
                        else if(map[i][j] == '<') direction = 3;
                    }
                }
            }

            br.readLine();
            char[] operations = br.readLine().toCharArray();
            gameStart(map, x, y, direction, operations);

            sb.append(String.format("#%d %s", t, mapToString(map)));
        }

        System.out.println(sb);
    }

    public static void gameStart(char[][] map, int x, int y, int direction, char[] operations){
        int[] tank = new int[]{x, y, direction};
        for(int i=0; i<operations.length; i++){
            char oper = operations[i];
            operation(map, tank, oper);
        }
    }

    public static void operation(char[][] map, int[] tank, char oper){
        if(oper == 'U'){
            tank[2] = 0;
        } else if (oper == 'D'){
            tank[2] = 2;
        } else if (oper == 'L'){
            tank[2] = 3;
        } else if (oper == 'R'){
            tank[2] = 1;
        } else if (oper == 'S'){
            int x = tank[0];
            int y = tank[1];
            while (true) {
                x += + dx[tank[2]];
                y += + dy[tank[2]];

                if(!(x >=0 && x<map.length && y>=0 && y<map[0].length)) break;

                if(map[x][y] == '#') break;
                else if(map[x][y] == '*'){
                    map[x][y] = '.';
                    break;
                }
            }
            return;
        }

        map[tank[0]][tank[1]] = tankDirection[tank[2]];
        int x = tank[0] + dx[tank[2]]; 
        int y = tank[1] + dy[tank[2]];
        if(!(x >=0 && x<map.length && y>=0 && y<map[0].length)) return;
        if(map[x][y] == '.'){
            map[x][y] = map[tank[0]][tank[1]];
            map[tank[0]][tank[1]] = '.';
            tank[0] = x;
            tank[1] = y;
        }
        
    }

    public static String mapToString(char[][] map){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                sb.append(map[i][j] + "");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
}