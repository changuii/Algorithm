import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] star = star(N);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<star.length; i++){
            sb.append(star[i]).append("\n");
        }
        System.out.println(sb);


        
    }


    public static String[] star(int N){


        if(N == 3){
            String[] star = new String[3];
            star[0] = "***";
            star[1] = "* *";
            star[2] = "***";
            return star;
        }

        String[] star = new String[N];
        String[] temp = star(N/3);
        for(int i=0; i<star.length; i++){
            if(i+1 <= N / 3 || N - N / 3 < i + 1)
                star[i] = temp[i%(N/3)].repeat(3);
            else{
                star[i] = temp[i%(N/3)] + " ".repeat(N/3) + temp[i%(N/3)];
            }
        }

        return star;
    }

}