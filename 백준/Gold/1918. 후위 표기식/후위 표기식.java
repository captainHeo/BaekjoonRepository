import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        //문자열 길이만큼 반복
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);

            switch (now){
                //연산자일때
                case '+':
                case '-':
                case '*':
                case '/':
                    //스택에 있는 연산자가 현재 연산자보다 우선순위가 높을 떄
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {
                        sb.append(stack.pop());
                    }
                    stack.add(now);
                    break;
                case '(':
                    stack.add(now);
                    break;
                case ')':
                    //스택이 비어있지 않고 피크값 (아니면
                    while(!stack.isEmpty() && stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    //(면 그냥 pop
                    stack.pop();
                    break;
                //피연산자는 그냥 출력할 문자열에 추가
                default:
                    sb.append(now);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }

    // 연산자 별 우선순위 리턴
    public static int priority(char operator){

        if(operator=='(' || operator==')'){
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }

}