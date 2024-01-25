
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

        System.out.println(sb);

    }
    public static void DFS(int number, int j){
        if(j == N){
            if(isPrime(number)){
                sb.append(number).append("\n");
            }
            return;
        }
        for(int i=1; i<10; i++){
            if(i%2 == 0){
                continue;
            }
            if(isPrime(number*10 + i)){
                DFS(number * 10 + i, j+1);
            }
        }


    }
    public static boolean isPrime(int num){
        for(int i=2; i<= num/2; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
