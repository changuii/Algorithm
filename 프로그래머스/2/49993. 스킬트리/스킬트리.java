import java.util.Arrays;
class Solution {
    
    static boolean[] visit;
    static char[] preSkills;
    static final char ALLOW = '.';
    public int solution(String skill, String[] skill_trees) {
        
        preSkills = new char[26];
        Arrays.fill(preSkills, '.');
        char[] skills = skill.toCharArray();
        for(int i=skills.length-1; i>=0; i--){
            if(i == 0) preSkills[skills[i] - 'A'] = ALLOW;
            else{
                preSkills[skills[i] - 'A'] = skills[i-1];
            }
        }
        
        int count = 0;
        for(String now : skill_trees){
            visit = new boolean[26];
            char[] val = now.toCharArray();
            if(isAllow(val)) count++;
        }
        
        return count;
    }
    
    
    public boolean isAllow(char[] skills){
        for(char skill : skills){
            
            char val = preSkills[skill - 'A'];
            if(val != '.' && !visit[val - 'A']) return false;
            else{
                visit[skill - 'A'] = true;
            }
        }
        return true;
        
    }
}