import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] star = makeStar(N);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(star[i]).append("\n");
        }
        System.out.println(sb);


    }

    public static String[] makeStar(int N){
        String[] star = new String[N];

        if(N == 1) {
            star[0] = "*";
            return star;
        }
        else{
            String[] temp = makeStar(N/3);
            for(int i=0; i<N; i++){
                if(i < N/3 || i >= N/3 *2)
                    star[i] = temp[i%(N/3)].repeat(3);
                else
                    star[i] = temp[i%(N/3)] + " ".repeat(N/3) + temp[i%(N/3)];
            }
        }
        return star;
    }

}