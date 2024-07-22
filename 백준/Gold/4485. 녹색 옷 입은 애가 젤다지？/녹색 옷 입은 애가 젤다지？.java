import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int size;
    static boolean[][] visit;
    static int[][] map;
    static int[][] answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        size = Integer.parseInt(br.readLine());
        int c = 1;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(size > 0){

            map = new int[size][size];
            answer = new int[size][size];
            visit = new boolean[size][size];
            for(int i=0; i<size; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<size; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            
            BFS();
            // for(int i=0; i<size; i++){
            //     for(int j=0; j<size; j++){
            //         System.out.print(answer[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
            sb.append("Problem ").append(c++).append(": ")
                .append(answer[size-1][size-1]).append("\n");
            size = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);

        
    }

    public static void BFS(){

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});
        visit[0][0] = true;
        answer[0][0] = map[0][0];
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int valueX = now[0] + dx[i];
                int valueY = now[1] + dy[i];
                if(valueX >= 0 && valueY >= 0 && valueX < size && valueY < size){
                    if(!visit[valueX][valueY]){
                        q.add(new int[]{valueX, valueY});
                        visit[valueX][valueY] = true;
                        answer[valueX][valueY] = answer[now[0]][now[1]] + map[valueX][valueY];
                    }else{
                        if(answer[now[0]][now[1]] + map[valueX][valueY] < answer[valueX][valueY]){
                            answer[valueX][valueY] =  answer[now[0]][now[1]] + map[valueX][valueY];
                            q.add(new int[]{valueX, valueY});
                        }
                    }
                    
                }
            }
        }
        
    }

}