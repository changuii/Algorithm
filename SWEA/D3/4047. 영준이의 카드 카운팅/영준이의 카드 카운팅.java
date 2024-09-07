import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Map<Character, Integer> map = new HashMap<>();
        map.put('S', 0);
        map.put('D', 1);
        map.put('H', 2);
        map.put('C', 3);
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int test=1; test<=T; test++){
            boolean[][] dec = new boolean[4][14];
            int[] cnt = new int[4];
            char[] value = br.readLine().toCharArray();
            boolean flag = true;

            for(int i=0; i<value.length / 3; i++){
                Character type = value[i * 3];
                int num = Integer.parseInt(value[i*3 + 1] +""+ value[i*3 + 2]);
                
                if(!dec[map.get(type)][num]){
                    dec[map.get(type)][num] = true;
                    cnt[map.get(type)]++;
                }else{
                    flag = false;
                    break;
                }
            }
            
            sb.append("#").append(test).append(" ")
                .append(flag ? (13 - cnt[0]) + " " + (13-cnt[1]) + " " + (13-cnt[2]) + " " + (13-cnt[3]): "ERROR").append("\n");
            
        }
        System.out.println(sb);


        
    }
}