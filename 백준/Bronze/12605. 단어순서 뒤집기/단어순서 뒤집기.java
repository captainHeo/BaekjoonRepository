import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<String> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        //입력한 수만큼 반복
        for(int i=1; i<=N; i++) {

            //띄어쓰기로 구분해 토큰 만드는
            st = new StringTokenizer(br.readLine(), " ");

            //토큰 수만큼 반복해 스택에 넣기
            while (st.hasMoreTokens()) {

                stack.push(st.nextToken());
            }

            sb.append("Case #" + i + ": ");

            while (! stack.isEmpty()) {
                sb.append(stack.pop() + " ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
