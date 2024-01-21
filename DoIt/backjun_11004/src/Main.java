import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int[] A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        qucikSort(A, 0, N-1, M-1);

        System.out.println(A[M-1]);

    }


    public static void qucikSort(int[] arr, int start, int end, int M){
        if(start < end){
            int pivot = partition(arr, start, end);
            if(pivot == M) return;
            else if(M < pivot) qucikSort(arr, start, pivot-1, M);
            else qucikSort(arr, pivot+1, end, M);
        }
    }

    public static int partition(int[] arr, int start, int end){
        if(start + 1 == end){
            if(arr[start] > arr[end]) swap(arr, start, end);
            return end;
        }
        int M = (start + end) / 2;
        swap(arr, start, M);
        int pivot = arr[start];
        int i = start+1;
        int j = end;
        while(i <= j){
            // i선택
            while(arr[i] < pivot && i <= end ) i++;
            // j선택
            while(arr[j] > pivot && j >= start+1) j--;

            // i가 j보다 작거나 같다면 교체
            if(i<=j){
                swap(arr, i++, j--);
            }
        }

        // j와 pivot 교체 pivot을 기준으로 나눠짐 -> pivot은 정렬완료
        arr[start] = arr[j];
        arr[j] = pivot;
        return j;
    }

    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}