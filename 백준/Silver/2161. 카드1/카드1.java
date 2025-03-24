import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i=1; i<=N; i++){
            q.addFirst(i);
        }

        StringBuilder sb = new StringBuilder();
        while(q.size() > 1){
            sb.append(q.pollLast()).append(" ");
            q.addFirst(q.pollLast());
        }

        sb.append(q.pollLast());
        System.out.println(sb);
    }
}