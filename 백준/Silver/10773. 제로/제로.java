import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Integer> st = new Stack<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        for(int i=0; i<K; i++) {
            int N = Integer.parseInt(br.readLine());

            if(N == 0)
                st.pop();
            else
                st.push(N);
        }

        int sum = 0;

        //스택에 있는 값 모두 합
        for(int o : st){
            sum+= o;
        }
        System.out.println(sum);
    }
}
