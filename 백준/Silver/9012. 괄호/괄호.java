import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> q = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            char[] values = br.readLine().toCharArray();
            boolean isVPS = true;
            
            for(final char v : values){
                if(v == '('){
                    q.addLast(v);
                }
                else{
                    if(q.isEmpty()){
                        isVPS = false;
                        break;
                    }
                    q.pollLast();
                }
            }

            if(!q.isEmpty()){
                isVPS = false;
            }
            q.clear();
            if(!isVPS){
                sb.append("NO\n");
                continue;
            }
            sb.append("YES\n");
        }

        System.out.println(sb);
    }
}