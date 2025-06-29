import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/10799
class Main {
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] values = br.readLine().toCharArray();

        Deque<Character> q = new ArrayDeque<>();

        int answer = 0;
        for(int i=0; i<values.length; i++){
            char now = values[i];

            if(now == '('){
                q.addLast(now);
            }
            else{
                q.pollLast();
                if(values[i-1] == '('){
                    answer += q.size();
                }
                else {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}