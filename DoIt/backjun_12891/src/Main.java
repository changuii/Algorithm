import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] m;
    static int[] c;
    static int check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int answer = 0;
        char[] A = br.readLine().toCharArray();

        m = new int[4];
        c = new int[4];
        check = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<4; i++){
            c[i] = Integer.parseInt(st.nextToken());
            if(c[i] == 0) check++;
        }

        for(int i=0 ;i<P; i++){
            Add(A[i]);
        }
        if(check == 4)answer++;

        for(int i=P; i<S; i++){
            int j = i - P;
            Add(A[i]);
            Remove(A[j]);
            if(check == 4){
                answer++;
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static void Add(char data){
        switch (data){
            case 'A':
                m[0]++;
                if(c[0] == m[0]) check++;
                break;
            case 'C':
                m[1]++;
                if(c[1] == m[1]) check++;
                break;
            case 'G':
                m[2]++;
                if(c[2]==m[2]) check++;
                break;
            case 'T':
                m[3]++;
                if(c[3]==m[3]) check++;
                break;
        }
    }
    private static void Remove(char data){
        switch (data){
            case 'A':
                if(c[0] == m[0]) check--;
                m[0]--;
                break;
            case 'C':
                if(c[1] == m[1]) check--;
                m[1]--;
                break;
            case 'G':
                if(c[2]==m[2]) check--;
                m[2]--;
                break;
            case 'T':
                if(c[3]==m[3]) check--;
                m[3]--;
                break;
        }
    }

}