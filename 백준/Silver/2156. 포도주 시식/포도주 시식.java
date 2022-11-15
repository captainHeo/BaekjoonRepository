import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static Integer[] dp;
    static int[] ar;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        ar = new int[N + 1];

        for(int i = 1; i < N + 1; i++) {
            ar[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = ar[1];

        /*
         *  N이 1로 주어질 수 있으므로 이럴 때를 위해 조건식
         *  또한 dp[2]는 어떤 경우에도 첫 번째와 두 번째를 합한 것이 최댓값
         */
        if(N > 1) {
            dp[2] = ar[1] + ar[2];
        }

        //입력한 수부터 시작해 탑 다운
        System.out.println(recur(N));
    }

    static int recur(int N) {

        if(dp[N] == null) {
            dp[N] = Math.max(
                    Math.max( recur(N - 2), recur(N - 3) + ar[N - 1] )
                            + ar[N],
                    recur(N - 1) );
        }

        return dp[N];
    }
}
