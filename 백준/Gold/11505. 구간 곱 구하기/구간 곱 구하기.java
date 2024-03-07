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
        while (true){
            if(Math.pow(2, k) > N) break;
            k++;
        }

        int startIndex = (int) Math.pow(2, k);
        tree = new long[startIndex * 2];

        Arrays.fill(tree, 1);

        for(int i=startIndex; i< startIndex + N; i++){
            tree[i] = Long.parseLong(br.readLine());
        }

        for(int i=startIndex-1; i>0; i--){
            tree[i] = tree[2*i] * tree[2 * i +1] % divide;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<K + M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) + startIndex -1;
            int c = Integer.parseInt(st.nextToken());

            if(a == 1){
                changeNum(b, c);
            }else if(a == 2){
                c += startIndex -1;
                sb.append(rangeTimes(b, c) % divide).append("\n");
            }
        }
        System.out.println(sb);



    }

    public static void changeNum(int index, int value){
        tree[index] = value;
        index /= 2;


        while (index > 0){
            tree[index] = tree[index*2] * tree[index*2+1] % divide;
            index /= 2;
        }
    }

    public static long rangeTimes(int startIndex, int endIndex){
        long value = 1;

        while (startIndex <= endIndex){
            if(startIndex % 2 == 1) value = (value * tree[startIndex]) % divide;
            if(endIndex % 2 == 0) value = (value * tree[endIndex]) % divide;

            startIndex = (startIndex +1) /2;
            endIndex = (endIndex - 1)/2;
        }

        return value;
    }


}