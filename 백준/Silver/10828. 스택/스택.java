import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        //입력받을 횟수
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            //입력 명령어 공백으로 쪼개 토큰 만들기
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {

                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(pop()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "top":
                    sb.append(top()).append('\n');
                    break;
            }

        }
        System.out.println(sb);
    }

    public static void push(int item) {

        stack.push(item);
    }

    public static int pop() {

        if(stack.isEmpty())
            return -1;
        else
            return stack.pop();
    }

    public static int size() {

        return stack.size();
    }

    public static int empty() {

        if(stack.isEmpty())
            return 1;
        else
            return 0;
    }

    public static int top() {

        if(stack.isEmpty())
            return -1;
        else
            return stack.peek();
    }

}