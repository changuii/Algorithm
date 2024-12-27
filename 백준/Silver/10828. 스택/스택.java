import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            String oper = st.nextToken();

            switch (oper) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!stack.isEmpty()){
                        sb.append((stack.pop())).append("\n");
                    } else{
                        sb.append("-1\n");
                    }
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? "1" : "0").append("\n");
                    break;
                case "top":
                    if(!stack.isEmpty()){
                        sb.append((stack.peek())).append("\n");
                    } else{
                        sb.append("-1\n");
                    }
                    break;
            }
            
        }
        System.out.println(sb);
    }
}