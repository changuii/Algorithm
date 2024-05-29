class Solution {
    public int[] solution(String s) {
        int count = 0;
        int c =0;
        while(s.length() > 1){
            // 0 제거 -> replace()를 통해 "0"을 제거하고, 
            // 이전 값과 현재 값의 길이 차이를 통해 0의 개수를 구한다.
            String now = s.replaceAll("0", "");
            count += s.length() - now.length();
            s = now;
            
            // 0이 제거된 문자열의 길이를 2진수로 변환해야 한다.
            int v = s.length();
            String convert = "";
            // 44를 2진수로 변환하는 과정은 다음과 같다.
            // 44
            // 2 - 22 ... 0
            // 2 - 11 ... 0
            // 2 - 5  ... 1
            // 2 - 2  ... 1
            // 2 - 1  ... 0
            // 2 - 0  ... 1
            // 따라서 101100이 된다.
            while( v >= 1){
                convert = (v % 2) + convert;
                v = v / 2;
            }
            s = convert;
            c++;
        }
        
        return new int[]{c, count};
    }
}