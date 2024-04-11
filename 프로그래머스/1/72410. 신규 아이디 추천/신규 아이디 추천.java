class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        String sub = "";
        for(int i=0; i<new_id.length(); i++){
            char value = new_id.charAt(i);
            if((value < 'a' || value > 'z') && (value < '0' || value > '9')&&
                value != '-' && value != '_' && value != '.'){
            }else{
                sub += value+"";
            }
        }
        new_id = "";
        boolean flag = false;
        for(int i=0; i<sub.length(); i++){
            char value = sub.charAt(i);
            if(value == '.' && !flag){
                flag = true;
                new_id += value+"";
            }else if(value == '.' && flag){
                
            }else{
                flag = false;
                new_id += value+"";
            }
        }
        
        if(new_id.charAt(0) == '.'){
            new_id = new_id.substring(1);
        }
        if(new_id.length() > 0){
            if(new_id.charAt(new_id.length()-1) == '.'){
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }
        
        if(new_id.equals("")) new_id = "a";
        
        if(new_id.length() >= 15){
            new_id = new_id.substring(0, 15);
        }
        if(new_id.length() > 0){
            if(new_id.charAt(new_id.length()-1) == '.'){
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }
        if(new_id.length() <= 2){
            while(new_id.length() < 3){
                new_id += new_id.charAt(new_id.length()-1)+"";
            }
        }
        return new_id;
    }
}