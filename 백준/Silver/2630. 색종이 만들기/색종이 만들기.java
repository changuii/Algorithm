import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] input = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                input[i][j] = sc.nextInt();
        }

        String result =cut(n, 0, n, 0, n, input);
        int b = 0;
        int w = 0;
        for(int i=0; i<result.length(); i++){
            if(result.charAt(i) == '1'){
                b += 1;
            }else{
                w += 1;
            }
        }
        System.out.println(w);
        System.out.println(b);
    }

    public static String cut(int n,int rstart, int rend,int cstart, int cend, int[][] input){
        int z = input[rstart][cstart];
        if(n == 1 ){
            return z== 1 ? "1" : "0" ;
        }
        int c = 0;
        for(int i = rstart; i<rend; i++){
            for(int j = cstart; j<cend; j++){
                if(z != input[i][j]){
                    c = 1;
                    break;
                }
            }
            if(i+1 == rend && c==0){
                return z==1 ? "1" : "0";
            }else if(c == 1){
                break;
            }
        }
        String result = "";
        result +=cut(n/2, rstart, rend-n/2, cstart, cend-n/2, input);
        result +=cut(n/2, rend-n/2, rend, cstart, cend-n/2, input);
        result +=cut(n/2, rstart, rend-n/2, cend-n/2, cend, input);
        result +=cut(n/2, rend-n/2, rend, cend-n/2, cend, input);

        return result ;

    }
}