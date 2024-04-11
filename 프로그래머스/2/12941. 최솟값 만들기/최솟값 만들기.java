import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int sum = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int j = A.length-1;
        for(int i=0; i<A.length; i++){
            sum += A[i] * B[j--];
        }

        return sum;
    }
}