import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        makeDecryptionTable();
        for(int t=1; t<=T; t++){

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[] codes = new String[N];
            for(int i=0; i<N; i++){
                codes[i] = br.readLine();
            }
            

            String code = "";
            for(int i=0; i<N && code.length() == 0 ; i++){
                for(int j=0; j<=M - 56; j++){
                    if(map.containsKey(codes[i].substring(j, j+7)) && isValidCode(codes[i].substring(j, j+56))){
                        code = codes[i].substring(j, j+56);
                        break;
                    }    
                }
            }

            // System.out.println(code);
            int[] text = decryption(code);
            sb.append(String.format("#%d %d\n", t, isValid(text) ? Arrays.stream(text).sum() : 0));
        }
        System.out.println(sb);
    }

    public static boolean isValidCode(String code){
        for(int i=0; i<8; i++){
            String now = code.substring(i*7, (i * 7)+7);
            if(map.getOrDefault(now, 100) == 100) return false;
        }
        return true;
    }

    public static int[] decryption(String code){
        int[] plainText = new int[8];

        for(int i=0; i<8; i++){
            String now = code.substring(i*7, (i * 7)+7);
            plainText[i] = map.get(now);
        }

        return plainText;
    }

    public static boolean isValid(int[] text){
        return ((text[0] + text[2] + text[4] + text[6]) * 3 + text[1] + text[3] + text[5] + text[7]) % 10 == 0 
            ? true : false;
    }

    public static void makeDecryptionTable(){
        map.put("0001101", 0);
        map.put("0011001", 1);
        map.put("0010011", 2);
        map.put("0111101", 3);
        map.put("0100011", 4);
        map.put("0110001", 5);
        map.put("0101111", 6);
        map.put("0111011", 7);
        map.put("0110111", 8);
        map.put("0001011", 9);
    }
}