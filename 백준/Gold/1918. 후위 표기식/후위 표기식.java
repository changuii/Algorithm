import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] values = br.readLine().toCharArray();

        ArrayDeque<Character> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(char v : values){
            if(v >= 'A' && v <= 'Z'){
                sb.append(v);
                continue;
            }

            // 현재 값이 닫는 괄호라면 여는 괄호가 나올 때까지 연산자를 출력하고, 여는 괄호라면 반복을 중단한다.
            while(v == ')'){
                if(q.peekLast() == '('){
                    q.pollLast();
                    break;
                }
                sb.append(q.pollLast());
            }
            if(v == ')'){
                continue;
            }

            // 현재 스택이 비어있거나, 혹은 top이 여는 괄호거나 현재 연산자가 여는 괄호라면 스택에 값을 쌓는다.
            // 현재 값이 이전 값보다 우선순위가 높은 경우, 스택에 값을 쌓는다.
            // 우선순위가 높은 경우는 이전 값이 + 혹은 - 이면서 현재 값이 * 혹은 /인 경우에만 우선순위가 더 높다.
            // 현재 값이 + 혹은 -라면 이전 값이 무조건 우선순위가 더 높고, * 혹은 /인 경우에도 이전값이 + 혹은 -여야만 우선순위가 더 높다.
            // 우선순위가 더 높은 경우에만 스택에 값을 쌓는다.
            if(q.isEmpty() || q.peekLast() == '(' || v == '(' || ((q.peekLast() == '-' || q.peekLast() == '+') && (v == '*' || v == '/'))){
                q.addLast(v);
                continue;
            }

            // 스택이 비어있지 않거나, 탑의 값이 여는 괄호가 아닌 경우 반복한다.
            // 이전 값보다 우선순위가 작다면 스택의 값들을 출력한다.
            while(!(q.isEmpty() || q.peekLast() == '(' || ((q.peekLast() == '-' || q.peekLast() == '+') && (v == '*' || v == '/')))){
                sb.append(q.pollLast());
            }
            // 앞의 while()의 조건이 true가 되었다면 현재 값을 스택에 쌓는다.
            q.addLast(v);
            
        }
        while(!q.isEmpty()){
            if(q.peekLast() == '(') {
                q.pollLast();
                continue;
            }
            sb.append(q.pollLast());
        }

        System.out.println(sb);
    }
}