import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<A.length; i++){
            int max = i;
            for(int j=i+1; j<A.length; j++){
                if(Integer.parseInt(A[j]+"") > Integer.parseInt(A[max]+""))
                    max = j;
            }
            if(i != max) {
                char temp = A[max];
                A[max] = A[i];
                A[i] = temp;
            }
            sb.append(A[i]);
        }

        System.out.println(sb);
    }
}