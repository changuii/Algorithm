import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
   
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] B = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        

        int[] left = new int[N];
        int[] right = new int[N];
        int[] min = new int[N];
        Arrays.fill(min, Integer.MAX_VALUE);
        // x 높이의 건물이 존재할 때, x높이의 건물 좌측에 보이는 건물은 x보다 커야한다.
        for(int i=0; i<N; i++){
            for(int j=i-1; j>=0; j--){
                if(B[i] < B[j]){
                    left[i] = left[j] + 1;
                    min[i] = j;
                    break;
                }
            }            
        }
        for(int i=N-1; i>=0; i--){
            for(int j=i+1; j<N; j++){
                if(B[i] < B[j]){
                    right[i] = right[j] + 1;
                    if(Math.abs(i - min[i]) > Math.abs(i - j)){
                        min[i] = j;
                    }
                    break;
                }
            }
        }

        // for(int i=0; i<N; i++){
        //     System.out.print((i+1)+ " : ");
        //     for(int now : list[i]){
        //         System.out.print(now + " ");
        //     }
        //     System.out.println();
        // }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            if(left[i] + right[i] == 0){
                sb.append("0").append("\n");
            }
            else{
                sb.append(left[i] + right[i]).append(" ").append(min[i] + 1).append("\n");
                
            }
        }
        System.out.println(sb);


    }
}