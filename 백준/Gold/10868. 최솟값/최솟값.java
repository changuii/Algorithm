import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int k = 0;
        while (true){
            if(Math.pow(2, k) >= N) break;
            k++;
        }

        int startIndex = (int) Math.pow(2, k);
        tree = new int[startIndex * 2];

        for(int i=startIndex; i<startIndex + N; i++){
            tree[i] = Integer.parseInt(br.readLine());
        }

        for(int i=startIndex-1; i>0; i--){
            tree[i] = Math.min(tree[i * 2], tree[ i * 2 + 1]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) + startIndex-1;
            int b = Integer.parseInt(st.nextToken()) + startIndex-1;

            sb.append(rangeMin(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    public static int rangeMin(int startIndex, int endIndex){
        int min = 1000000001;

        while (startIndex <= endIndex){
            if(startIndex % 2 == 1 && min > tree[startIndex]) min = tree[startIndex];
            if(endIndex % 2 == 0 && min > tree[endIndex]) min = tree[endIndex];

            startIndex = (startIndex + 1) /2;
            endIndex = (endIndex - 1) / 2;
        }

        return min;
    }




}