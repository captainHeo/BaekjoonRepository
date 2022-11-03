import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        dp[0] = dp[1] = 0;

        System.out.print(recur(N));
    }

    // 2와 3의 배수, 즉 6으로 나눠지는 경우의 수
    // 각 부분에 재귀호출을 하면서 DP를 최솟값으로 갱신해주어야 한다. 이 때 앞서 말한 것 처럼 무조건 큰 수로 나누는 것이 최솟값이 아니기 때문에 이를 조심

    static int recur(int N) {

        //null 이 아니면
        if (dp[N] == null) {

            // 6으로 나눠지는 경우
            if (N % 6 == 0) {
                // 3으로 나누는 경우와 2로 나누는 경우, 1을 빼는 경우 모두 재귀호출 하여 3가지 경우 중 최솟값으로 DP를 갱신
                // 1을 더하여 연산 횟수 증가
                dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2) ) ) + 1;
            }
            // 3으로만 나눠지는 경우
            else if (N % 3 == 0) {
                // 3으로 나누는 경우와 1을 빼는 경우를 재귀호출,
                dp[N] = Math.min(recur(N / 3), recur(N - 1) ) + 1;
            }
            // 2로만 나눠지는 경우
            else if (N % 2 == 0) {
                // 2로 나누는 경우와 1을 빼는 경우의 수를 재귀호출,
                dp[N] = Math.min(recur(N / 2), recur(N - 1) ) + 1;
            }
            // 2와 3으로 나누어지지 않는 경우
            else {
                // 그 외에는 1을 빼는 경우만 재귀호출
                dp[N] = recur(N - 1) + 1;
            }
        }
        return dp[N];
    }

}
