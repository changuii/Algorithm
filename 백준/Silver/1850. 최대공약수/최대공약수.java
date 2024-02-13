import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      long a = Long.parseLong(st.nextToken());
      long b = Long.parseLong(st.nextToken());

      long N = gcd(a, b);
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i<N; i++){
          sb.append(1);
      }
      System.out.println(sb);
    }

    private static long gcd(long a, long b){

        if(a % b == 0L){
            return b;
        }else{
            return gcd(b, a % b);
        }



    }



}