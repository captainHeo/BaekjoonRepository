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

            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '(')
                    push(s.charAt(i));
                else{
                    pop(s.charAt(i));
                }

            }

            if(stack.isEmpty())
                sb.append("YES").append('\n');
            else
                sb.append("NO").append('\n');

            stack.clear();
        }
        System.out.println(sb);
    }

    public static void push(char c) {
        stack.push(c);
    }

    public static void pop(char c) {
        if(!stack.isEmpty() && stack.peek() == '(')
            stack.pop();
        else
            stack.push(c);
    }
}
