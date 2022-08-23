import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //1부터 N까지 자연수 중 중복 없이 M개를 고른
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //값을 담을 배열 2
        arr = new int[M];
        //재귀를 하면서 이미 방문한 노드(값)이라면 다음 노드를 탐색하도록 하기 위해
        //(유망한 노드인지 검사하기 위해) N 크기의 boolean 배열을 생성
        //4
        visit = new boolean[N];
        dfs(N, M, 0);//깊이는 0부터 시작
        System.out.println(sb);

    }

    //4 2 0
    public static void dfs(int N, int M, int depth) {
        //M과 깊이가 같으면
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        //1부터 N까지 자연수중 중복없이 M개를 고른 수열
        //0 1 2 3
        for (int i = 0; i < N; i++) {

            //방문하지 않은 노드라면
            if (!visit[i]) {
                //방문 체크
                visit[i] = true;
                //베얄에 값 넣기
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }

}