import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {

    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Node[][] map = new Node[N+1][N+1];
            
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    map[i][j] = new Node(0);
                }
            }

            map[N/2][N/2].val = 2;
            map[N/2][N/2+1].val = 1;
            map[N/2+1][N/2].val = 1;
            map[N/2+1][N/2+1].val = 2;

            // for(int j=1; j<=N; j++){
            //     System.out.println(Arrays.toString(map[j]));
            // }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                map[a][b].val = w;

                reverseRock(map, a, b, w);
                // System.out.println(a + ", " + b);
                // for(int j=1; j<=N; j++){
                //     System.out.println(Arrays.toString(map[j]));
                // }
            }

            int[] answer = new int[3];
            for(int i=1; i<=N; i++){
                // System.out.println(Arrays.toString(map[i]));
                for(int j=1; j<=N; j++){
                    answer[map[i][j].val]++;
                }
            }
            sb.append(String.format("#%d %d %d\n", t, answer[1], answer[2]));
        }
        System.out.println(sb);
    }
    public static void reverseRock(Node[][] map, int a, int b, int w){
        ArrayList<Node> list = new ArrayList<>();
        for(int i=0; i<8; i++){
            for(int j=1; j<map.length; j++){
                int x = a + dx[i]*j;
                int y = b + dy[i]*j;

                if(!(x >=1 && x <map.length && y>=1 && y<map.length && map[x][y].val != 0)) break;

                if(map[x][y].val != w){
                    list.add(map[x][y]);
                }
                else{
                    reverseRockCount(list, w);
                    break;
                }
            }
            list.clear();
        }
    }

    public static void reverseRockCount(ArrayList<Node> list, int w){
        for(Node now : list){
            now.val = w;
        }
    }

    

    static class Node{
        int val;

        public Node(int val){
            this.val=val;
        }
        public String toString(){
            return String.format("[ %d ]", this.val);
        }
    }
}