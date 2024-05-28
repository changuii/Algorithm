import java.util.*;
class Solution {
    public long solution(long n) {
        char[] x = new String(n+"").toCharArray();
        Arrays.sort(x);
        return Long.parseLong(new StringBuilder(new String(x)).reverse().toString());
    }
}