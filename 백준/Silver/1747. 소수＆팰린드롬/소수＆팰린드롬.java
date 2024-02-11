import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {

        int N = new Scanner(System.in).nextInt();

        // 에라토스테네스의 체
        // 1,000,000이 값으로 들어왔을 때 소수이면서 팰린드롬인 수 중 가장 최소값 1003001
        boolean[] A = new boolean[1003002];
        for(int i=2; i<Math.sqrt(A.length); i++){
            if(A[i]) continue;
            for(int j = i + i; j<A.length; j += i){
                A[j] = true;
            }
        }

        // N이 1이라면 1을 제외시켜야함.
        for(int i = N > 1 ? N : 2; i<A.length; i++){
            if(!A[i] && isPalindrome(i)){
                System.out.println(i);
                break;
            }
        }


    }

    public static boolean isPalindrome(int num){
        String number = String.valueOf(num);
        String reverse = new StringBuilder().append(num).reverse().toString();

        if(number.equals(reverse)) return true;
        else return false;
    }



}