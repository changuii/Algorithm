import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] A;
    static int[] S;
    static long answer  = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        S = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0, N-1);
        System.out.println(answer);


    }

    private static void mergeSort(int start, int end){
        if(end - start < 1) return;

        int D = start + (end - start) / 2;
        mergeSort(start, D);
        mergeSort(D+1, end);
        for(int i=start; i<=end; i++){
            S[i] = A[i];
        }

        int i=start;
        int j=D+1;
        int index = start;
        while(i <= D && j <=end){
            if(S[i] <= S[j]){
                A[index++] = S[i++];
            }else{
                answer += j - index;
                A[index++] = S[j++];
            }
        }
        while (i <= D){
            A[index++] = S[i++];
        }
        while (j <= end){
            A[index++] = S[j++];
        }

    }

}