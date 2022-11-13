import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int[] ar;		// 배열 
    static Integer[] dp;	// 메모이제이션 할 dp
    static int max;			// 최댓값 변수 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ar = new int[N];
        dp = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        /*
         * dp[0]은 첫 원소로 이전에 더이상 탐색할 것이 없기 때문에
         * arr[0] 자체 값이 되므로 arr[0]으로 초기화 해준다.
         * max 또한 첫 번째 원소로 초기화 해준다.
         */
        dp[0] = ar[0];
        max = ar[0];

        // dp 의 마지막 index는 N-1이므로 N-1부터 Top-Down 탐색 
        recur(N - 1);

        System.out.println(max);
    }

    static int recur(int N) {

        // 탐색하지 않은 인덱스라면
        // 결국 recur 1까지 간다, 0은 값이 있으므로
        // 이전 인덱스까지 재귀 돌린 값과 현재 값 더한 값 그리고 현재 값을 비교해 더 큰 값을 dp 값에
        if(dp[N] == null) {
            dp[N] = Math.max(recur(N - 1) + ar[N], ar[N]);

            // 연속해서 선택한 수열의 합중 최대값 구하기
            // 해당 dp[N]과 max 중 큰 값으로 max 갱신 
            max = Math.max(dp[N], max);
        }
        //탐색한 인덱스면 바로 반환, recur(0) 이면 바로 반환
        return dp[N];
    }
}
