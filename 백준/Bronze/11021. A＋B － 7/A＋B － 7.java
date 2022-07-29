import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int sum = 0;

        for(int i=1; i<=N; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

            sb.append("Case #" + i +": " + sum).append("\n");
        }

        System.out.println(sb);
    }
}
