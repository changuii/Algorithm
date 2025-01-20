class Solution {
    public String solution(String s) {
        
        boolean isFirst = true;
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i<sb.length(); i++){
            if(sb.charAt(i) == ' ') {
                isFirst = true;
                continue;
            }
            
            if(isFirst){
               sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
                isFirst = false;
            }else{
                sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
            }
        }
        
        return sb.toString();
    }
}