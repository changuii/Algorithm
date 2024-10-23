import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());

        int[][] A = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = DFS(A, 0, 0, N);
        System.out.println(answer);
    }

    public static int DFS(int[][] A, int x, int y, int size){
        int val = 0;
        if(size == 1){
            val = A[x][y];
        }
        else if(size == 2){
            val = isSecondNumber(A[x][y], A[x+1][y], A[x][y+1], A[x+1][y+1]);
        }
        else{
            val = isSecondNumber(DFS(A, x, y, size / 2), DFS(A, x + size / 2, y, size / 2),
                                DFS(A, x, y + size / 2, size / 2), DFS(A, x + size / 2, y + size / 2, size / 2));
        }
        return val;
    }

    public static int isSecondNumber(int a, int b, int c, int d){
        int[] arr = new int[]{a, b, c, d};
        Arrays.sort(arr);
        return arr[1];
    }
}