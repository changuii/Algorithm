import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static Bomb[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int R;
    static int C;;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        map = new Bomb[R][C];

        ArrayList<Bomb> before = new ArrayList<>();
        for(int i=0; i<R; i++){
            char[] value = br.readLine().toCharArray();
            for(int j=0; j<value.length; j++){
                map[i][j] = new Bomb(0, value[j], i, j);
                before.add(map[i][j]);
            }
        }

        // 1초 후
        if(N == 1){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    sb.append(map[i][j].value+"");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            return;
        }
        // 2초 후
        ArrayList<Bomb> after = new ArrayList<>();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j].value == '.'){
                    map[i][j].value = 'O';
                    map[i][j].time = 2;
                    after.add(map[i][j]);
                }
            }
        }
        if(N % 2 == 0){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    sb.append(map[i][j].value+"");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            return;
        }
        // 3초 이후
        // i -> 3 : before 폭발 false
        // i -> 4 : before에 저장 false
        // i -> 5 : after 폭발 true
        // i -> 6 : after에 저장 true
        // i -> 7 : before 폭발 false
        // i -> 8 : before 저장 false
        // i -> 9 : after 폭발 true

        boolean flag = false;
        for(int i=3; i<N+1; i++){
            if(i % 2 == 0){
                // 채우기
                List value = flag ? after : before;
//                System.out.println("TIME : " +i + " " +  (i / 2 ) % 2);
                for(int x=0; x<R; x++){
                    for(int y=0; y<C; y++){
                        if(map[x][y].value == '.'){
//                            System.out.println(map[x][y].x +" " + map[x][y].y + " " + map[x][y].time + " " + map[x][y].value);
                            map[x][y].time = i;
                            map[x][y].value = 'O';
                            value.add(map[x][y]);
                        }
                    }
                }
                flag = !flag;
            }else{
                boom(flag ? after : before, i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                sb.append(map[i][j].value+"");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void boom(ArrayList<Bomb> bombs, int time){
//        System.out.println("TIME : " +time);
        for(Bomb b : bombs){
//            System.out.println(b.x +" " + b.y + " " + b.time + " " + b.value);
            if(time-3 == b.time && b.value == 'O'){
                b.value = '.';
                for(int i=0; i<4; i++){
                    int valueX = b.x + dx[i];
                    int valueY = b.y + dy[i];
                    if(valueX < 0 || valueX >= R  || valueY < 0 || valueY >= C) continue;
                    if(map[valueX][valueY].time != time-3) map[valueX][valueY].value = '.';
                }
            }
        }
        bombs.clear();
    }

    public static class Bomb{
        int x;
        int y;
        int time;
        char value;
        public Bomb(int time, char value, int x, int y){
            this.time=time;
            this.value=value;
            this.x=x;
            this.y=y;
        }
    }
}

