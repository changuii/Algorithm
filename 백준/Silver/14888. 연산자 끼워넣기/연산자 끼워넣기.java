import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] num;
    static int[] select;
    static int[] op;
    static int max;
    static int min;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        num = new int[N];
        select = new int[N-1];
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth) {
        if(depth == num.length - 1) {

            int result = num[0];
            for(int i=0; i<select.length; i++) {
                result = calculate(select[i], result, num[i+1]);
            }

            max = Math.max(max, result);
            min = Math.min(min, result);
            
        }


        for(int i=0; i<op.length; i++){
            if(op[i] != 0) {
                op[i]--;
                select[depth] = i;
                dfs(depth + 1);
                op[i]++;
            }
        }
    }

    public static int calculate(int select, int a, int b) {
        if(select == 0) {
            return a + b;
        } 
        else if (select == 1) {
            return a - b;
        }
        else if (select == 2) {
            return a * b;
        }

        if(a < 0) {
            return (Math.abs(a) / b) * -1; 
        }
        return a / b;
    }
}