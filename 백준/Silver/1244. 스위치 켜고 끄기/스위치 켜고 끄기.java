import java.util.*;
import java.lang.*;
import java.io.*;


// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        // 사용 배열 1 ~ N
        boolean[] v = new boolean[N+2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            // 1은 true 0은 false
            v[i] = st.nextToken().equals("1");
        }

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            String gender = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            // 성별이 남성이면
            if(gender.equals("1")){
                int count = 1;
                // x = value ~ value * 2, value * 3 ...
                for(int x=value; x<=N; x = value * count){
                    count++;
                    // 스위치 반전
                    v[x] = !v[x];
                }
            }
            // 성별이 여성이면
            else{
                int count = 1;
                // 현재 스위치 반전
                v[value] = !v[value];
                while(true){
                    // 현재 접근하려는 위치가 1 ~ N을 벗어났다면 종료
                    if(value + count > N || value - count <= 0) break;
                    if(v[value + count] == v[value - count]){
                        v[value + count] = !v[value+count];
                        v[value - count] = !v[value-count];
                    }else break;
                    count++;
                }
            }   
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(v[i] ? "1" : "0").append(" ");
            if(i % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
        
        
        
    }
}