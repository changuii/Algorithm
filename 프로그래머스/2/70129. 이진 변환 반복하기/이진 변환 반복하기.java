
class Solution {
    public int[] solution(String s) {
        int count = 0;
        int zero = 0;
        while(s.length() > 1){
            int temp = s.length();
            // 1. 0 제거
            s = s.replaceAll("0", "");
            zero += temp - s.length();
            // 2. s의 길이를 2진법 문자열로
            s = Integer.toBinaryString(s.length());
            count++;
        }
        return new int[]{count, zero};
    }
}