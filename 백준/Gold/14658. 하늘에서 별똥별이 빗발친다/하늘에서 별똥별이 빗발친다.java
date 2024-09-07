import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static ArrayList<int[]> stars;
    static int L;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        stars = new ArrayList<>();
        
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            stars.add(new int[]{x, y});
        }

        int max = 0;
        for(int[] valX : stars){
            for(int[] valY : stars){
                max = Math.max(max, getStar(valX[0], valY[1]));
            }
        }
        System.out.println(K - max);
    }

    public static int getStar(int x, int y){
        int c = 0;
        for(int[] star : stars){
            if(star[0] >= x && star[0] <= x+L && star[1] >= y && star[1] <= y+L) c++;
        }

        return c;
    }
}