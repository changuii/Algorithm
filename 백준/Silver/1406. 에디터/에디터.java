import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String init = br.readLine();
        int N = Integer.parseInt(br.readLine());

        Deque<Character> left = new LinkedList<>();
        Deque<Character> right = new LinkedList<>();
        for(int i=0; i<init.length(); i++){
            left.addLast(init.charAt(i));
        }

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            if(oper.equals("L")){
                if(left.size() > 0){
                    right.addFirst(left.pollLast());
                }
            }
            else if(oper.equals("D")){
                if(right.size()>0){
                    left.addLast(right.poll());
                }
                
            }
            else if(oper.equals("B")){
                if(left.size()>0){
                    left.pollLast();
                }
            }
            else if(oper.equals("P")){
                char value = st.nextToken().charAt(0);
                left.addLast(value);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char x : left){
            sb.append(x+"");
        }
        for(char x : right){
            sb.append(x+"");
        }
        System.out.println(sb);
    }
}