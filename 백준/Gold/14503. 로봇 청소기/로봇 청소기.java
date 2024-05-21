import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int[][] map;
    // 북, 동, 남, 서

    // 0 -> 2
    // 1 -> 3
    // 2 -> 0
    // 3 -> 1
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());

       map = new int[N][M];

       st = new StringTokenizer(br.readLine());
       int startX = Integer.parseInt(st.nextToken());
       int startY = Integer.parseInt(st.nextToken());
       int startD = Integer.parseInt(st.nextToken());
       Robot robot = new Robot(startX, startY, startD);

       for(int i=0; i<N; i++){
           st = new StringTokenizer(br.readLine());
           for(int j=0; j<M; j++){
               map[i][j] = Integer.parseInt(st.nextToken());
           }
       }


       while (!robot.end){
           clean(robot);
       }

        System.out.println(robot.count);
    }

    public static void clean(Robot robot){
        if(map[robot.x][robot.y] == 0){
            map[robot.x][robot.y] = 2;
            robot.count++;
        }

        boolean flag = false;
        for(int i=0; i<4; i++){
            int valueX = robot.x + dx[i];
            int valueY = robot.y + dy[i];
            if(map[valueX][valueY] == 0){
                flag = true;
                break;
            }
        }

        if(flag){
            robot.d = (robot.d + 3) % 4;
            if(map[robot.x + dx[robot.d]][robot.y + dy[robot.d]] == 0){
                robot.x = robot.x + dx[robot.d];
                robot.y = robot.y + dy[robot.d];
            }
        }
        else{
            int reverseD = (robot.d + 2) % 4;
            if(map[robot.x + dx[reverseD]][robot.y + dy[reverseD]] == 1){
                robot.end = true;
                return;
            }
            robot.x = robot.x + dx[reverseD];
            robot.y = robot.y + dy[reverseD];
        }
    }

    public static class Robot{
        int x;
        int y;
        int d;
        int count;
        boolean end;
        public Robot(int x, int y, int d){
            this.x=x;
            this.y=y;
            this.d=d;
            this.count = 0;
            this.end = false;
        }
    }


}

