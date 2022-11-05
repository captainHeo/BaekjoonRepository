import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int dp[] = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(dp(N));
    }

    private static int dp(int N) {

        if(N == 1)
            return 1;
        if(N == 2)
            return 2;
        if(dp[N] != 0)
            return dp[N];

        return dp[N] = (dp(N -1) + dp(N -2)) % 10007;
    }
}
