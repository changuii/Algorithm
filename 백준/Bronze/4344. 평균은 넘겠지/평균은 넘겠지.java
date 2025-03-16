import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double[] result = new double[N];

        for(int i=0; i<N; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());

            int c = 0;
            double avg = 0;
            int[] values = new int[M];
            for(int j=0; j<M; j++){
                values[j] = Integer.parseInt(st.nextToken());
                avg += values[j];
            }

            avg /= M;

            for(int j=0; j<M; j++){
                if(values[j] > avg){
                    c++;
                }
            }

            result[i] = (double) c / M * 100;
            
            
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(String.format("%.3f%%\n", result[i]));
        }

        System.out.println(sb);
        
        
    }
}