import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<char[]> values = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        int max = 0;
        for(int i=0; i<5; i++) {
            values.add(br.readLine().toCharArray());
            max = Math.max(values.get(i).length, max);
        }

        for(int i=0; i<max; i++) {
            for(int j=0; j<5; j++) {
                char[] value = values.get(j);
                if(value.length > i) {
                    sb.append(value[i]);
                }
            }
        }
        

        System.out.println(sb);
    }
}