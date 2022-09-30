import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            //행에서 맨 마지막 값은 이전 열의 값들 모두 더해준
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        int sum = 0;

        for (int k = 1; k <= m; k++) {

            sum = 0;

            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i <= x2; i++) {

                //y1-1, y1 2면 1은 포함하지 않는거니
                //마지막 행의 값이 총합이니 거기서 첫 번째 열의 값 빼기
                sum = sum + (dp[i][y2] - dp[i][y1-1]);
            }

            sb.append(sum + "\n");
        }
        System.out.print(sb);
    }
}
