import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] val = br.readLine().toCharArray();
        boolean[] visit = new boolean[N];

        int c1 = 0;
        for(int i=0; i<N; i++){

            if(val[i] == 'H') continue;

            for(int j=i-k; j <= i + k; j++){
                if(j < 0 ) continue;
                if(j == i) j++;
                if(j >= N ) break;
                if(!visit[j] && val[j] == 'H'){
                    visit[j] = true;
                    c1++;
                    break;
                }
            }
        }

        System.out.println(c1);
        
    }
}