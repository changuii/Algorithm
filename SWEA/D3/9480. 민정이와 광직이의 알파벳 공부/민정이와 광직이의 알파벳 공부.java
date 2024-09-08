import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static int num;
    static String[] word;
    static boolean[] visit;
    static int[] isAll;
    static int count;
    static int charCount;
     public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

         
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int test=1; test<=T; test++){
            num = Integer.parseInt(br.readLine());

            word = new String[num];
            visit = new boolean[num];
            isAll = new int[26];
            count = 0;
            charCount = 0;
            for(int i=0; i<num; i++){
                word[i] = br.readLine();
            }
            DFS(0);
            
            sb.append("#").append(test).append(" ")
                .append(count);
            if(test != T) sb.append("\n");
            
        }
        System.out.println(sb);
    }

    public static void DFS(int now){
        if(charCount == 26){
            count++;
        }
        for(int i=now; i<num; i++){
            if(!visit[i]){
                visit[i] = true;
                for(int j=0; j<word[i].length(); j++){
                    if(isAll[word[i].charAt(j) - 'a'] == 0){
                        charCount++;
                    }
                    isAll[word[i].charAt(j) - 'a']++;
                }
                DFS(i+1);
                for(int j=0; j<word[i].length(); j++){
                    if(isAll[word[i].charAt(j) - 'a'] == 1){
                        charCount--;
                    }
                    isAll[word[i].charAt(j) - 'a']--;
                }
                visit[i] = false;
            } 
        }
    }

    
}