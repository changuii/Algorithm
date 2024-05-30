import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 모두 이하
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node> n = new ArrayList<>();
        n.add(new Node("", -1));
        int index = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            if(n.get(index).value == power) continue;
            index++;
            n.add(new Node(type,power));
        }

        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            int target = Integer.parseInt(br.readLine());
            
            int low = 0;
            int high = n.size();
            int mid = 0;
            while(low <= high){
                mid = (low + high) / 2;
                
                if(target <= n.get(mid).value){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            
            sb.append(n.get(high+1).type).append("\n");
        }
        System.out.println(sb);
        
    }

    static class Node{
        String type;
        int value;
        public Node(
            String type,
            int value
        ){
            this.value=value;
            this.type=type;
        }
    }
}