import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        boolean[] V = new boolean[N];
        LinkedList<Integer>[] list = new LinkedList[N];

        for(int i=0; i<N; i++){
            list[i] = new LinkedList<>();
        }

        for(int i=1; i<M+1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        for(int i=1; i<N; i++){
            V[i] = false;
        }
        int answer = 0;

        for(int i=1; i<N; i++){
            if(!V[i]){
                answer++;
                V[i] = true;
                while(!list[i].isEmpty()){
                    if(!V[list[i].getFirst()])
                        stack.push(list[i].removeFirst());
                }
                while (!stack.isEmpty()){
                    int next = stack.pop();
                    V[next] = true;
                    while (!list[next].isEmpty()){
                        stack.push(list[next].removeFirst());
                    }

                }
            }
        }
        System.out.println(answer);


    }

}