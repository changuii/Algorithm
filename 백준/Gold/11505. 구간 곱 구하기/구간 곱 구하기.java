import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static long[] tree;
    static int divide = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int k = 0;
        while (Math.pow(2, k) < N){
            k++;
        }

        int startIndex = (int) Math.pow(2, k);
        tree = new long[startIndex * 2];
        Arrays.fill(tree, 1);

        for(int i=startIndex; i<startIndex+ N; i++){
            tree[i] = Integer.parseInt(br.readLine());
        }
        for(int i=startIndex-1; i>0; i--){
            tree[i] = (tree[i*2] * tree[i*2 +1]) % divide;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M + K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) + startIndex-1;
            int c = Integer.parseInt(st.nextToken());
            if(a == 1){
                changeValue(b, c);
            }else{
                c += startIndex-1;
                sb.append(rangeTimes(b, c)).append("\n");
            }


        }
        System.out.println(sb);

    }
    public static void changeValue(int index, int value){

        tree[index] = value;
        index /= 2;

        while (index > 0){
            tree[index] = (tree[2 * index] * tree[2 * index + 1]) % divide ;
            index /= 2;
        }


    }

    public static long rangeTimes(int startIndex, int endIndex){
        long value = 1;

        while (startIndex <= endIndex){
            if(startIndex % 2 == 1) value = (value * tree[startIndex]) % divide;
            if(endIndex % 2 == 0) value = (value * tree[endIndex]) % divide;

            startIndex = (startIndex + 1) / 2;
            endIndex = (endIndex - 1) / 2;
        }


        return value;
    }




}