import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int i = 0;
        int j = N - 1;

        if (A[j] > 0 && A[i] < 0) {
            System.out.println(A[i] + " " + A[j]);
        } else {
            int minx = 0;
            int miny = N - 1;
            while (i < j) {
                if (Math.abs(A[i] + A[j]) < Math.abs(A[minx] + A[miny])) {
                    minx = i++;
                    miny = j--;
                }
                if (A[j] < 0) i++;
                else if (A[i] > 0) j--;
            }

            System.out.println(A[minx] + " " + A[miny]);
        }
    }
}