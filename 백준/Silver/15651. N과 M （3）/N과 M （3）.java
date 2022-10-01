import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int ar[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ar = new int[M];

        DFS(0);

        System.out.println(sb);
    }

    //이전과 다르게 s를 파라미터로 갖지 않는다
    //중복 순열이므로,
    //레벨
    private static void DFS(int L) {

        //출력할 순열 개수와 레벨 일치하면 출력
        if(L == M) {

            for (int i : ar) {
                sb.append(i + " ");
            }
            sb.append("\n");

        } else {
            //N은 무조건 1이상이니 1부터 시작
            for(int i=1; i<=N; i++) {
                //현재 레벨에 해당하는 인덱스에 값 넣기
                ar[L] = i;

                DFS(L + 1);
            }
        }
    }
}
