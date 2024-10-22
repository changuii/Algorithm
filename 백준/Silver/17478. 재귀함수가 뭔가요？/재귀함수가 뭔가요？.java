import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    private static final String WHAT_IS_RECURSION = "\"재귀함수가 뭔가요?\"";
    private static final String RECURSION_STORY1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    private static final String RECURSION_STORY2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    private static final String RECURSION_STORY3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    private static final String RECURSION_ANSWER = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    private static final String ANSWERED_THAT = "라고 답변하였지.";
    private static final String RECURSION_DEPTH = "____";
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        
        answer.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
        whatIsRecursion(1, N, answer);
        System.out.println(answer);
    }

    public static void whatIsRecursion(int depth, int N, StringBuilder sb){
        makeRecursionDepth(sb, depth);
        sb.append(WHAT_IS_RECURSION).append("\n");
        if(depth <= N){
            makeRecursionDepth(sb, depth);
            sb.append(RECURSION_STORY1).append("\n");
            makeRecursionDepth(sb, depth);
            sb.append(RECURSION_STORY2).append("\n");
            makeRecursionDepth(sb, depth);
            sb.append(RECURSION_STORY3).append("\n");
            whatIsRecursion(depth+1, N, sb);
        }
        else{
            makeRecursionDepth(sb, depth);
            sb.append(RECURSION_ANSWER).append("\n");
        }
        makeRecursionDepth(sb, depth);
        sb.append(ANSWERED_THAT).append("\n");
    }

    public static void makeRecursionDepth(StringBuilder sb, int depth){
        for(int i=1; i<depth; i++){
            sb.append(RECURSION_DEPTH);
        }
    }
}