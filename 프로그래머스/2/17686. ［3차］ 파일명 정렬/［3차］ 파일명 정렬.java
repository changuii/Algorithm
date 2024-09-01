import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public String[] solution(String[] files) {
        
        ArrayList<String[]> splitFiles = new ArrayList<>();
        
        for(int j=0; j<files.length; j++){
            String file = files[j];
            String[] split = new String[4];
            split[0] = file;
            char[] charVal = file.toCharArray();
            
            int start = 0;
            int end = 0;
            for(int i=0; i<charVal.length; i++){
                if(start == 0 && charVal[i] >= '0' && charVal[i] <= '9')
                    start = i;
                else if(start != 0 && (charVal[i] < '0' || charVal[i] > '9')){
                    end = i;
                    break;
                }
            }
            split[1] = file.substring(0, start);
            split[2] = file.substring(start, end == 0 ? file.length() : end);
            split[3] = String.valueOf(j);
            splitFiles.add(split);
        }
        
        Collections.sort(splitFiles, (o1, o2) ->{
           if(!o1[1].toLowerCase().equals(o2[1].toLowerCase())){
               return o1[1].toLowerCase().compareTo(o2[1].toLowerCase());
           }
            int val = Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
            if(val == 0){
                return Integer.parseInt(o1[3]) - Integer.parseInt(o2[3]); 
            }
            return val;
            
        });
        
        // for(String[] val : splitFiles){
        //     System.out.println(Arrays.toString(val));
        // }
        
        String[] answer = new String[splitFiles.size()];
        for(int i=0; i<splitFiles.size(); i++){
            answer[i] = splitFiles.get(i)[0];
        }
        
        
        return answer;
    }
}