import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        Deque<Character> q = new ArrayDeque<>();
        while (true) {
            String now = br.readLine();
            boolean isBalance = true;

            if(now.equals(".")) break;

            for(char c : now.toCharArray()) {
                if(c != '(' && c != ')' && c != '[' && c != ']') continue;

                if(q.isEmpty() && (c == ')' || c == ']')){
                    isBalance = false;
                    break;
                }

                if(c == '(' || c == '[') q.addLast(c);
                else if (c == ')' && q.peekLast() == '(') q.pollLast();
                else if (c == ']' && q.peekLast() == '[') q.pollLast();
                else {
                    isBalance = false;
                    break;
                }
                
            }
            if(!q.isEmpty()) isBalance = false;

            sb.append(isBalance ? "yes" : "no").append("\n");
            q.clear();
        }

        System.out.println(sb);
    }
}