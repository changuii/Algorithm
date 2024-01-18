import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] NGE = new int[N];
        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++){
            while(!stack.isEmpty() && A[stack.peek()] < A[i]){
                NGE[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++){
            if(NGE[i] == 0) sb.append(-1).append(" ");
            else sb.append(NGE[i]).append(" ");
        }

        System.out.println(sb);

    }
}