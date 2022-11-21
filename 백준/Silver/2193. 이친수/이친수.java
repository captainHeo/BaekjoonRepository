import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static long dp[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new long[N+1];

        System.out.println(Calculate(N));
    }

    public static long Calculate(int N){
        if(N == 0){
            return 0;
        }
        //1자리수면 0과 1둘중에 하나, 0으로 시작하면 이천수 아니니 1만 해당 1 반환
        if(N == 1){
            return 1;
        }
        //구해진 값이면 dp 값 반환
        if(dp[N] > 0){
            return dp[N];
        }
        dp[N] = Calculate(N-1) + Calculate(N-2);
        return dp[N];
    }
}