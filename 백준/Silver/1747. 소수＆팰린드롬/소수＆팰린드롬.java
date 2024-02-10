
import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {

        int N = new Scanner(System.in).nextInt();


        boolean[] A = new boolean[100000001];
        for(int i=2; i<Math.sqrt(A.length); i++){
            if(A[i]) continue;
            for(int j = i+i; j<A.length; j += i){
                A[j] = true;
            }
        }

        for(int i = N > 1 ? N : 2; i<A.length; i++){
            if(!A[i]){
                if(check(i)){
                    System.out.println(i);
                    break;
                }
            }
        }


    }


    public static boolean check(int x){

        String target = String.valueOf(x);
        String reverse = new StringBuilder().append(x).reverse().toString();
        if(target.equals(reverse))
            return true;
        else{
            return false;
        }
    }



}