import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /* 내가 푼 부분 */
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        int answer = 0;
        String a = br.readLine();
        for(int i=0; i<testcase; i++){
            answer += Integer.parseInt(String.valueOf(a.charAt(i)));
        }
        System.out.println(answer);
        */
        /* 책에서 제공한 풀이 + 내 풀이 */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 입력을 String으로 받고 char[]으로 변경
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for(int i =0; i<N; i++){
            sum += cNum[i] - '0';
        }
        System.out.println(sum);


    }
}