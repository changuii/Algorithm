import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            char[] oper = br.readLine().toCharArray();

            int N = Integer.parseInt(br.readLine());
            String[] val = null;
            if(N == 0) {
                br.readLine();
                val = new String[0];
            }
            else {
                String x = br.readLine();
                x = x.substring(1, x.length() - 1);
                val = x.split(",");
            }
            Str s = new Str(val);

            boolean result = true;
            for(char c : oper) {
                if(c == 'D') {
                    result = s.D();
                    if(!result) break;
                }
                else if(c == 'R') {
                    s.R();
                }
            }

            if(result) {
                sb.append(s.print());
            }
            else {
                sb.append("error");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Str {
        int dir;
        List<String> val;

        public Str(String[] val) {
            this.val = new ArrayList<>(Arrays.asList(val));
            dir = 0;
        } 

        public boolean D() {
            if(val.size() == 0) return false;

            if(dir == 0) {
                val.remove(0);
            }
            else{
                val.remove(val.size() - 1);
            }
            
            return true;
        }

        public void R() {
            dir = (dir + 1) % 2;
        }

        public String print() {
           if(dir == 1) {
               Collections.reverse(val);
           }

            return String.format("[%s]",
                String.join(",", val)                    
            );
        }
        
    }
}