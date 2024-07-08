import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        // 0에 가장 가까운 용액을 만들어내는 두 용액을 찾는 프로그램

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] value = new int[N];
        for(int i=0; i<N; i++){
            value[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = N-1;
        int[] min = new int[]{i, j};
        while(i < j){
            int x = value[i];
            int y = value[j];
            if(Math.abs(x + y) 
               <= Math.abs(value[min[0]] + value[min[1]])){
                min[0] = i;
                min[1] = j;
                if(Math.abs(x) > Math.abs(y)){
                    i++;
                }else j--;
            }else if(Math.abs(x) > Math.abs(y)){
                i++;
            }else{
                j--;
            }
        }

        System.out.println(value[min[0]] + " " + value[min[1]]);

        
    }
}