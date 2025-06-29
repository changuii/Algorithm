import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/11729
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] values = br.readLine().toCharArray();

        Deque<Character> q = new ArrayDeque<>();
        if(!isOk(q, values)){
            System.out.println(0);
            return;
        }
        

        int[] c = new int[2];
        int answer = 0;
        for(int i=0; i<values.length; i++){
            char now = values[i];
            if(now == '(' || now == '['){
                c[now == '(' ? 0 : 1]++;
                q.addLast(now);
            }
            else if(i > 0 && now == ')' && values[i-1] == '('){
                c[0]--;
                q.pollLast();
                answer += 2 * (c[0] > 0 ? Math.pow(2, c[0]) : 1) * (c[1] > 0 ? Math.pow(3, c[1]) : 1);
            }
            else if(i > 0 && now == ']' && values[i-1] == '['){
                c[1]--;
                q.pollLast();
                answer += 3 * (c[0] > 0 ? Math.pow(2, c[0]) : 1) * (c[1] > 0 ? Math.pow(3, c[1]) : 1);
            }
            else if((now == ')' && q.peekLast() == '(') || (now == ']' && q.peekLast() == '[')){
                q.pollLast();
                c[now == ')' ? 0 : 1]--;
            }
        }
        System.out.println(answer);
    }

    public static boolean isOk(Deque<Character> q, char[] values){

        for(int i=0; i<values.length; i++){
            char now = values[i];
            if(now == '(' || now == '['){
                q.addLast(now);
            }
            else if(!q.isEmpty() && ((now == ')' && q.peekLast() == '(') || 
                   (now == ']' && q.peekLast() == '['))){
                q.pollLast();
           }
            else{
                return false;
            }
        }

        return q.isEmpty();
    }
    
}