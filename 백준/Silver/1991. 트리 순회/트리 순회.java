import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int[][] tree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        tree = new int[26][2];

        for(int i=0; i<N; i++){
            String[] value = br.readLine().split(" ");
            int node = value[0].charAt(0) - 'A';
            char left = value[1].charAt(0);
            char right = value[2].charAt(0);

            tree[node][0] = left == '.' ? -1 : left - 'A';
            tree[node][1] = right == '.' ? -1 : right - 'A';
        }

        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        sb.append("\n");

        System.out.println(sb);
    }

    public static void preOrder(int now){
        if(now == -1) return;
        sb.append((char)(now + 'A'));
        preOrder(tree[now][0]);
        preOrder(tree[now][1]);
    }
    public static void inOrder(int now){
        if(now == -1) return;
        inOrder(tree[now][0]);
        sb.append((char)(now + 'A'));
        inOrder(tree[now][1]);
    }

    public static void postOrder(int now){
        if(now == -1) return;
        postOrder(tree[now][0]);
        postOrder(tree[now][1]);
        sb.append((char)(now+'A'));
    }



}