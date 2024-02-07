import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] A = new int[N][2];


        StringTokenizer st;
        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine(), " ");
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        // 종료시간이 짧은 것 우선
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                else return o1[1] - o2[1];
            }
        });


        int answer = 0;
        int now = 0;
        for(int i=0; i<N;i++){
            if(A[i][0] >= now) {
                answer++;
                now = A[i][1];
            }
        }

        System.out.println(answer);
    }
}