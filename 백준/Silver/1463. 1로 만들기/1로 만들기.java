import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    static int[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())+1;

        D = new int[N];
        for(int i=0; i<N; i++){
            D[i]= -1;
        }
        D[0] = 100000000;
        D[1] = 0;

        System.out.println(operation(N-1));
    }
    public static int operation(int x){
        if(D[x] == -1){
            int divide1 = x %2 == 0 ? operation(x/2) : 1000000000;
            int divide2 = x % 3 == 0 ? operation(x / 3) : 1000000000;
            int minus = operation(x - 1);

            if(divide1 > divide2)
                divide1 = divide2;
            if(divide1 < minus)
                return D[x] = divide1 + 1;
            return D[x] = minus + 1;
        }
        return D[x];
    }

}