import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    // 종료 시간이 우선인 것을 최선으로
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());

      int[][] A = new int[N][2];


      StringTokenizer st;
      for(int i=0; i<N; i++){
          st = new StringTokenizer(br.readLine(), " ");
          int start = Integer.parseInt(st.nextToken());
          int end = Integer.parseInt(st.nextToken());
          A[i][0] = start;
          A[i][1] = end;
      }

      Arrays.sort(A, new Comparator<int[]>() {
          @Override
          public int compare(int[] o1, int[] o2) {
              if(o1[1] == o2[1]) return o1[0] - o2[0];
              else return o1[1] - o2[1];
           }
      });

      int answer = 0;
      int end = -1;
      for(int i=0; i<N; i++){
          if(A[i][0] >= end){
              end = A[i][1];
              answer++;
          }
      }

      System.out.println(answer);



    }





}