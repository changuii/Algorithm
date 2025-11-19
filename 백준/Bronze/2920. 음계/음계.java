import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[8];

        boolean isAscending = true;
        boolean isDescending = true;

        int idxDesc = 8;
        for(int i=0; i<8; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            if(num[i] != i+1) isAscending = false;
            if(num[i] != idxDesc) isDescending = false;

            idxDesc--;
        }

        if(isAscending) {
            System.out.println("ascending");
        }
        else if(isDescending) {
            System.out.println("descending");
        }
        else {
            System.out.println("mixed");
        }

    }
    
}