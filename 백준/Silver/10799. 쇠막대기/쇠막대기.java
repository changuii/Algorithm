import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] values = br.readLine().toCharArray();

        Deque<Character> q = new ArrayDeque<>();

        for(char v : values){
            if(q.isEmpty()) q.addLast(v);
            else if(v == '(') q.addLast(v);
            else if(v == ')' && q.peekLast() == '('){
                q.pollLast();
                q.addLast('1');
            }
            else q.addLast(v);
        }

        while (!q.isEmpty()) {
            if(q.peekFirst() == '('){
                search(q);
            } else{
                q.pollFirst();
            }
        }
        System.out.println(answer);
    }

    public static int search(Deque<Character> q){
        if(q.peekFirst() == '('){
            int c = 0;
            q.pollFirst();
            while(q.peekFirst() != ')'){
                c += search(q);
            }
            q.pollFirst();
            answer += c + 1;
            return c;
        }
        else if(q.peekFirst() == '1'){
            q.pollFirst();
            return 1;
        }

        return 0;
    }
}