import java.util.*;
import java.lang.*;
import java.io.*;


// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        
        int man = 0;
        if(game.equals("Y")) man = 1;
        else if(game.equals("F")) man = 2;
        else man = 3;

        int pCount = 0;
        Set<String> s = new HashSet<>();
        for(int i=0; i<N; i++){
            String player = br.readLine();
            if(s.contains(player)) continue;
            pCount++;
            s.add(player);
        }

        System.out.println(pCount / man);
        
        
    }
}