class Solution {
    int video, now, opStart, opEnd;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] temp = video_len.split(":");
        video = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        
        temp = pos.split(":");
        now = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        
        temp = op_start.split(":");
        opStart = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        
        temp = op_end.split(":");
        opEnd = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        
        jump();
        for(String command : commands){
            if(command.equals("next")){
                next();
            }
            else{
                prev();
            }
            jump();
        }
        
        return (now / 60  < 10 ? "0" : "")+ (now / 60) + ":" + (now % 60 < 10 ? "0" : "") + (now % 60);
    }
    
    public void next(){
        if(now + 10 >= video) now = video;
        else now += 10;
    }
    
    public void prev(){
        if(now - 10 <= 0) now = 0;
        else now -= 10;
    }
    
    public void jump(){
        if(now >= opStart && now <= opEnd) now = opEnd;
    }
    
}