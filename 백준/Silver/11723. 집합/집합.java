import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int set = 0;
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            String oper = st.nextToken();
            int value = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
            
            if(oper.equals("add")){
                set |= (1 << value);
            }
            else if(oper.equals("remove")){
                set &= ~(1 << value);
            }
            else if(oper.equals("check")){
                sb.append(((set & (1 << value)) == (1 << value) ? "1" : "0"))
                    .append("\n");
            }
            else if(oper.equals("toggle")){
                set ^= (1 << value);
            }
            else if(oper.equals("all")){
                set = (1 << 21) - 1;
            }
            else{
                set = 0;
            }
        }
        System.out.println(sb);
    
        
    }
}