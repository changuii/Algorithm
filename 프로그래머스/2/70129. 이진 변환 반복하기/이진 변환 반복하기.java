class Solution {
    public int[] solution(String s) {
        int c = 0;
        int z = 0;
        
        while(!s.equals("1")){
            c++;
            
            int len = s.length();
            s = s.replace("0", "");
            z += len - s.length();
            
            s = convert2(s.length());
        }
        
        
        return new int[] {c, z};
    }
    
    public String convert2(int value){
        StringBuilder result = new StringBuilder();
        
        while(value != 0){
            result.insert(0,value % 2);
            value /= 2;
        }
        return result.toString();
    }
}