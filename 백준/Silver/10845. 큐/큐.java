import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Deque<String> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            String oper = st.nextToken();

            if(oper.equals("push")){
                q.addLast(st.nextToken());
            }
            else if (oper.equals("pop")){
                if(q.size() == 0){
                    sb.append("-1").append("\n");
                    continue;
                }

                sb.append(q.pollFirst()).append("\n");
            }
            else if (oper.equals("size")){
                sb.append(q.size()).append("\n");
            }
            else if (oper.equals("empty")){
                if(q.isEmpty()){
                    sb.append("1").append("\n");
                    continue;
                }

                sb.append("0").append("\n");
            }
            else if (oper.equals("front")){
                if(q.size() == 0){
                    sb.append("-1").append("\n");
                    continue;
                }

                sb.append(q.peekFirst()).append("\n");
            } else{
                if(q.size() == 0){
                    sb.append("-1").append("\n");
                    continue;
                }

                sb.append(q.peekLast()).append("\n");
            }
        }

        System.out.println(sb);
    }
}