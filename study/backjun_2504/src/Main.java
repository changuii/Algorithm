import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int c = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] A = br.readLine().toCharArray();
        br.close();

        Stack<Character> stack = new Stack<>();

        stack.push(A[0]);
        for(int i=1; i<A.length; i++){
            char target = A[i];
            if(check(target, stack.peek())== 1){
                stack.pop();
                stack.push('2');
            }else if(check(target, stack.peek()) == 2){
                stack.pop();
                stack.push('3');
            }else{
                stack.push(target);
            }
        }
        while(!stack.isEmpty()){
            
        }





        System.out.println("Hello world!");
    }

    private static int check(char x, char y){
        if(x == '(' && y == ')') return 1;
        else if(x == '[' && y == ']') return 2;
        else return 0;
    }

}