import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/9663
class Main {
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] visit = new int[N][N];
        dfs(visit, 0);

        System.out.println(answer);
    }

    public static void dfs(int[][] visit, int depth){
        if(depth == visit.length-1){
            for(int i=0; i<visit[0].length; i++){
                if(visit[depth][i] == 0){
                    answer++;
                }
            }
            return;
        }

        for(int i=0; i<visit[0].length; i++){
            if(visit[depth][i] == 0){
                check(visit, depth, i, 1);
                dfs(visit, depth + 1);
                check(visit, depth, i, -1);
            }
        }
    }

    public static void check(int[][] visit, int x, int y, int value){

        for(int i=0; i<dx.length; i++){
            int X = x + dx[i];
            int Y = y + dy[i];

            while(X >= 0 && Y >= 0 && X < visit.length && Y < visit[0].length){
                visit[X][Y] += value;
                X += dx[i];
                Y += dy[i];
            }
        }
        
    }
}