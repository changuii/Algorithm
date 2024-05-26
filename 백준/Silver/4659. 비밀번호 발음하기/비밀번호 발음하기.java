import java.util.*;
import java.lang.*;
import java.io.*;


// a :0
// e :4
// i :8
// o :14
// u :20
// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Character> m = new HashSet<>();
        m.add('a');
        m.add('e');
        m.add('i');
        m.add('o');
        m.add('u');
        
        StringBuilder sb = new StringBuilder();
        String value = "";
        while(true){
            value = br.readLine();
            if(value.equals("end")) break;
            char[] v = value.toCharArray();
            int count = 0;
            boolean flag = false;
            for(int i=0; i<v.length; i++){
                // 모음 검사
                if(m.contains(v[i])) count++;
                if(i > 0){
                    if(i+1 < v.length){
                        // 모음이 3개 연속으로 오는지 체크
                        if(m.contains(v[i]) 
                           && m.contains(v[i-1]) && m.contains(v[i+1])){
                            flag = true;
                            break;
                        // 자음이 3개 연속으로 오는지 체크
                       }else if(!m.contains(v[i]) 
                           && !m.contains(v[i-1]) && !m.contains(v[i+1])){
                            flag = true;
                            break;
                       }
                    }
                    // e와 o가 둘다 아니면서, 현재 값과 이전 값이 동일
                    if(v[i] != 'e' && v[i] != 'o' && v[i] == v[i-1]){
                        flag = true;
                        break;
                    }else if(i+1 < v.length){
                        // e와 o 둘 중 하나면서, 현재 값과 이전 값, 다음 값이 동일
                        if((v[i] == 'e' || v[i] == 'o' )
                           && v[i] == v[i-1] && v[i] == v[i+1]){
                            flag = true;
                            break;
                       }
                    }
                } 
            }
            sb.append("<"+value+"> is ");
            if(!flag && count > 0){
                sb.append("acceptable.").append("\n");
            }else sb.append("not acceptable.").append("\n");
        }
       System.out.println(sb);
    }
}