import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    static int[][] arr;
    static Integer[][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //삼각형 크기
        N = Integer.parseInt(br.readLine());

        //삼각형 입력
        arr = new int[N][N];
        //경로 합 저장
        dp = new Integer[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            //i만큼 반복
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //가장 마지막 줄에 있는 값들은 dp 배열에도 넣어줌 
        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];
        }

        System.out.println(find(0, 0));

    }

    static int find(int depth, int idx) {
        // 마지막 행일 경우 현재 위치의 dp값 반환
        if(depth == N - 1) 
            return dp[depth][idx];

        // 탐색하지 않았던 값일 경우 다음 행의 양쪽 값 비교
        // 2차원 배열이니 바로 아래쪽, 바로 아래쪽의 오른쪽으로 뻗어나가는
        // 뻗어 나가다 방문된 곳은 계산되었으니 바로 값 반환
        // 마지막 줄 제외하고는 값이 없으니 마지막 줄까지 가서 마지막 줄에서 큰 값 가져와 현재 위치의 삼각형 값과 더해서 저장
        if (dp[depth][idx] == null) {
            dp[depth][idx] = Math.max( find(depth + 1, idx), find(depth + 1, idx + 1) ) + arr[depth][idx];
        }
        return dp[depth][idx];
    }
}
