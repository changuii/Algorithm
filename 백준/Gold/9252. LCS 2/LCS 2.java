import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] value1 = br.readLine().toCharArray();
        char[] value2 = br.readLine().toCharArray();

        long[][] A = new long[value1.length+1][value2.length+1];
        for(int i=1; i<A.length; i++){
            for(int j=1; j<A[0].length; j++){
                A[i][j] = value1[i-1] == value2[j-1] ? A[i-1][j-1] + 1 : Math.max(A[i-1][j], A[i][j-1]);
            }
        }

        String answer = "";
        int x = value1.length;
        int y = value2.length;
        while (x > 0 && y > 0){
            if(value1[x-1] == value2[y-1]){
                answer = value1[x-1] + answer;
                x--;
                y--;
            }else {
                if (A[x - 1][y] <= A[x][y - 1]) {
                    y--;
                } else {
                    x--;
                }
            }
        }

        System.out.println(A[value1.length][value2.length]);
        System.out.println(answer);
    }

}