import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 투포인터를 활용하여 주어진 값에 대한 합의 경우의 수를 구한다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int start = 1;
        int end = 1;
        int sum = 1;
        int answer = 1;
        while(end != N){
            if(sum == N){
                answer++;
                sum += ++end;
            }else if(sum > N){
                sum -= start++;
            }else{
                sum += ++end;
            }
        }
        System.out.println(answer);
    }
}