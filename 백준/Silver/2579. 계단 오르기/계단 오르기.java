import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static Integer dp[];
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        arr = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];	// 디폴트값이 null이므로 0으로 초기화 해주어야한다.
        dp[1] = arr[1];

        //계단수가 2개 이상이면
        if(N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(N));
    }

    static int find(int N) {
        // 아직 탐색하지 않는 N번째 계단일 경우
        // 연속해서 3번 오를 수 없으니
        // 2 계단 낮은 계단의 최대합과 3단계 낮은 계단의 최대합 + 1단계 낮은 계단 점수중 더 큰 값에
        // 현재 계단 더하기
        if(dp[N] == null) {
            dp[N] = Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N];
        }

        return dp[N];
    }
}