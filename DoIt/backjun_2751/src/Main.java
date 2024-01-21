import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        A = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(arr, 0, N-1);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);

    }

    public static void mergeSort(int[] arr, int start, int end){
        if(end - start < 1 ) return;

        // 현재 배열의 중앙값
        int D = start+(end-start)/2;

        // 배열을 분할한다.
        mergeSort(arr, start, D);
        mergeSort(arr, D+1, end);

        // 이전에 병합하면서 정렬했던 것을 A배열에 담아둔다.
        for(int i=start; i<=end; i++){
            A[i] = arr[i];
        }

        int i = start;
        int j = D+1;
        int index = start;
        // 두 개의 배열을 돌면서 작은 값을 추가한다.
        while (i <= D && j <= end){
            if(A[i] < A[j]){
                arr[index++] = A[i++];
            }else{
                arr[index++] = A[j++];
            }

        }
        // 배열에 남은 값들을 채운다.
        while (i <= D){
            arr[index++] = A[i++];
        }
        while(j <= end){
            arr[index++] = A[j++];
        }


    }


}