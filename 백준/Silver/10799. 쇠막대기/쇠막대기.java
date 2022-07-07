import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = bf.readLine();
        
        Stack<Character> stack = new Stack<>();

        int result = 0;
        
        for (int i = 0; i < input.length(); i++) {
            // 열린 괄호면 스택에 추가.
            if (input.charAt(i) == '(') { 
                
                stack.push('('); 
                
                continue;
            }
            
            if (input.charAt(i) == ')') { // 닫힌 괄호일 경우,
                
                stack.pop(); // 일단 stack에서 pop을 실행.

                //그 전 괄호가 열린 괄호면 레이저
                if (input.charAt(i - 1) == '(') {
                    //현재 stack의 사이즈만큼 더해 줌.
                    result += stack.size();
                    //그 전 괄호가 닫힌 괄호면 레이저가 아님.
                } else {
                    //단순히 1을 더해 줌.
                    result++; 
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bf.close();
        bw.close();
    }

}

