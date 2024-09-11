import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
   
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Building[] B = new Building[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            B[i] = new Building(i, Integer.parseInt(st.nextToken()));
        }

        Deque<Building> stack = new ArrayDeque<>();

        int[] left = new int[N+1];
        int[] right = new int[N+1];
        int[] min = new int[N+1];
        Arrays.fill(min, Integer.MAX_VALUE);
        // x 높이의 건물이 존재할 때, x높이의 건물 좌측에 보이는 건물은 x보다 커야한다.
        for(int i=1; i<=N; i++){
            while (!stack.isEmpty() && stack.peekFirst().height <= B[i].height){
                stack.pop();
            }
            left[i] = stack.size();
            if(stack.size() > 0){
                min[i] = stack.peekFirst().index;
            }
            stack.push(B[i]);
        }

        stack.clear();
        for(int i=N; i>0; i--){
            while (!stack.isEmpty() && stack.peekFirst().height <= B[i].height){
                stack.pop();
            }
            right[i] = stack.size();
            if(stack.size() > 0){
                min[i] = Math.abs(min[i] - i) <= Math.abs(stack.peekFirst().index - i) 
                    ? min[i] : stack.peekFirst().index;
            }
            stack.push(B[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            if(left[i] + right[i] == 0){
                sb.append("0").append("\n");
            }
            else{
                sb.append(left[i] + right[i]).append(" ").append(min[i]).append("\n");
                
            }
        }
        System.out.println(sb);


    }

    static class Building{
        int index;
        int height;

        public Building(int index, int height){
            this.index=index;
            this.height=height;
        }
    }
}