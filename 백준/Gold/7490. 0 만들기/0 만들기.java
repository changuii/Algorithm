import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static List<String> answer = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder s = new StringBuilder();
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            char[] oper = new char[n+1];
            DFS(n, 1, oper);

            Collections.sort(answer);
            for(String x : answer){
                s.append(x).append("\n");
            }
            answer = new ArrayList<>();
            
            s.append("\n");
        }

        System.out.println(s);
        
    }

    // tmp가 0이라면 tmp에 값을 담는다.
    // tmp가 0이 아니라면 tmp와 현재 값을 이어붙인다.
    // 현재 값이 첫번째 값이 아니라면 oper[i-1]의 부호를 붙인다.
    // oper[i-1]의 값이 공백이라면 tmp에 값을 담은채로 넘어간다.
    // oper[i-1]의 값이 공백이아니라면 list에 값을 담는다.
    // 현재 값이 첫번째 값이라면 list에 값을 담는다.
    public static void DFS(int n, int now, char[] oper){
        if(now == n){
            String value = "";
            int tmp = 0;
            List<Integer> list = new ArrayList<>();
            for(int i=n; i>0; i--){
                value = i + value;
                if(tmp > 0) tmp = Integer.parseInt(i +""+tmp);
                else tmp = i;
                if(i > 1){ 
                    value = oper[i-1] + value;
                    if(oper[i-1] != ' '){
                        list.add(
                          Integer.parseInt(oper[i-1] + ""+tmp)  
                        );
                        tmp = 0;
                    }
                }else{
                    list.add(tmp);
                    tmp = 0;
                } 
            }
            int sum = 0;
            for(int x : list){
                sum += x;
            }
            if(sum == 0){
                answer.add(value);
            }
        }
        else{
            oper[now] = '+';
            DFS(n, now + 1, oper);
            oper[now] = '-';
            DFS(n, now + 1, oper);
            oper[now] = ' ';
            DFS(n, now + 1, oper);
        } 
    }


    
}