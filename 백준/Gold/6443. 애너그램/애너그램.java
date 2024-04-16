import java.io.*;
import java.util.Arrays;

class Main {
    static char[] value;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            value = br.readLine().toCharArray();

            Arrays.sort(value);
            for(int j=0; j<value.length; j++){
                sb.append(value[j]);
            }
            sb.append("\n");

            while (nextPermutation(value)){
                for(int j=0; j< value.length; j++){
                    sb.append(value[j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean nextPermutation(char[] arr){
        int i = arr.length-1;
        int j = arr.length-1;
        // i가 i-1보다 사전순으로 더 큰 값을 가지는 문자를 찾는다.
        while(i > 0 && arr[i] <= arr[i-1]){
            i--;
        }

        if( i <= 0) return false;

        // j가 i-1보다 사전순으로 큰 값을 가지는 문자를 찾는다.
        while (arr[j] <= arr[i-1]){
            j--;
        }

        // swap
        char temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        j = arr.length-1;
        while (i<j){
            temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
        return true;
    }





}