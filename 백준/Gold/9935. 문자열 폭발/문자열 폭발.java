import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        char[] value = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();

        for(int i=0; i<value.length; i++){
            stack.push(value[i]);
            if(stack.size() >= target.length){
                boolean flag = true;

                for(int j=0; j<target.length; j++){
                    if(stack.get(stack.size() - target.length + j) != target[j]){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    for(int j=0; j<target.length; j++){
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char v : stack){
            sb.append(v);
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}