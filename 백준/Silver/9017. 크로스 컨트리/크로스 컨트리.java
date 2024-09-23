import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            Set<Integer> isSix = new HashSet<>();

            int[] five = new int[N+1];
            int[] th = new int[N];
            int[] c = new int[N+1];
            for(int i=0; i<N; i++){
                th[i] = Integer.parseInt(st.nextToken());
                c[th[i]]++;
                if(c[th[i]] == 5){
                    five[th[i]] = i;
                }
                if(c[th[i]] == 6){
                    isSix.add(th[i]);
                }
            }

            int sc = 1;
            int[] score = new int[N];
            int[] teamScore = new int[N+1];
            c = new int[N+1];
            for(int i=0; i<N; i++){
                if(!isSix.contains(th[i])) continue;
                score[i] = sc++;
                if(c[th[i]] >= 4) continue;
                c[th[i]]++;
                teamScore[th[i]] += score[i];
            }

            ArrayList<Integer> max = new ArrayList<>();
            for(int team : isSix){
                if(max.size() == 0) max.add(team);
                else{
                    if(teamScore[max.get(0)] > teamScore[team]){
                        max.clear();
                        max.add(team);
                    }    
                    else if(teamScore[max.get(0)] == teamScore[team]){
                        max.add(team);
                    }
                }
            }
            // System.out.println(Arrays.toString(teamScore));

            if(max.size() == 1)
                sb.append(max.get(0)).append("\n");
            else{
                int fiveMin = max.get(0);
                for(int i=1; i<max.size(); i++){
                    if(five[fiveMin] > five[max.get(i)])
                        fiveMin = max.get(i);
                }
                sb.append(fiveMin).append("\n");
            }
        }
        System.out.println(sb);
        
        

        
    }
}