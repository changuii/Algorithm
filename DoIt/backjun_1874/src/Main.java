import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Stack<Integer> stack = new Stack<>();

        int value = 1;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++){
            int target = sc.nextInt();
            while(value <= target){
                stack.push(value++);
                sb.append("+").append("\n");
            }
            if(target == stack.peek()){
                stack.pop();
                sb.append("-").append("\n");
            }else{
                sb = new StringBuffer();
                sb.append("NO");
                break;
            }

        }
        System.out.println(sb);


    }
}