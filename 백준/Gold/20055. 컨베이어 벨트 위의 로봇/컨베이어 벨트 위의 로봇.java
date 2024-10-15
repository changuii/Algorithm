import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int c;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Belt> top = new ArrayDeque<>();
        Deque<Belt> bottom = new ArrayDeque<>();
        
        for(int i=0; i<N * 2; i++){
            Belt b = new Belt(Integer.parseInt(st.nextToken()), false);
            if(i < N){
                top.addLast(b);
            }
            else{
                bottom.addFirst(b);
            }
        }

        c = 0;
        int step = 0;

        while (c < M) {
            step++;


            Belt b = top.pollLast();
            b.robot = false;
            bottom.addLast(b);

            moveRobot(top);

            b = bottom.poll();
            b.robot = b.h > 0;
            b.h--;
            if(b.h == 0) c++;
            top.addFirst(b);
        }

        System.out.println(step);
        

        
    }

    public static void moveRobot(Deque<Belt> top){
        Belt before = top.pollLast();
        Belt first = before;
        before.robot = false;
        top.addFirst(first);

        while (top.peekLast() != first) {
            Belt now = top.pollLast();
            
            if(now.robot && !before.robot && before.h > 0){
                before.h--;
                if(before.h == 0) c++;
                now.robot = false;
                before.robot = true;
            }
            before = now;
            top.addFirst(now);
        }

        top.peekLast().robot = false;
    }

    public static class Belt{
        int h;
        boolean robot;

        public Belt(int h, boolean robot){
            this.h=h;
            this.robot=robot;
        }
        
    }
}