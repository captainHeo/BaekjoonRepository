import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        //입력받을 횟수
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            //입력 명령어 공백으로 쪼개 토큰 만들기
            String s = br.readLine();

            //입력 문자열 크기만큼 반복
            for(int i=0; i<s.length(); i++) {


                if(s.charAt(i) == '(')
                    push(s.charAt(i));
                else{
                    pop(s.charAt(i));
                }

            }

            //중괄호 쌍이 서로 맞으면 스택이 비어있으니 YES 아니면 NO
            if(stack.isEmpty())
                sb.append("YES").append('\n');
            else
                sb.append("NO").append('\n');

            //한 줄에 하나의 스택 계산이니 한 줄 끝나면 비워주기
            stack.clear();
        }
        System.out.println(sb);
    }
    //(면 스택에 푸시
    public static void push(char c) {
        stack.push(c);
    }

    //)면 스택이 비어있지않고 peek가 (면 삭제, 그렇지 않으면 )도 푸시
    public static void pop(char c) {
        if(!stack.isEmpty() && stack.peek() == '(')
            stack.pop();
        else
            stack.push(c);
    }
}
