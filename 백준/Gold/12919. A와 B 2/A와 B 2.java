import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        DFS(S, T);
        System.out.println(answer);
    }


    private static void DFS(String s, String t){
        if (s.length() == t.length() || answer == 1){
            if(s.equals(t)) answer = 1;
            return;
        }

        if(t.endsWith("A")) DFS(s, operation1(t));
        if(t.startsWith("B")) DFS(s, operation2(t));
    }


    // T에서 뒤의 A를 제거하는 연산
    private static String operation1(String t){
        return t.substring(0, t.length()-1);
    }

    // T를 뒤집고 뒤의 B를 제거하는 연산
    private static String operation2(String t){
        return new StringBuilder(t).reverse().substring(0, t.length()-1);
    }
}