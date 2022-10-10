import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ar[], N, S, count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N =  Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        ar = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {

            ar[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);

        // S 0일때, 공집합도 합이 0이므로 공집합 빼줘야함
        if (S == 0)
            System.out.println(count - 1);
        else
            System.out.println(count);
    }

    private static void DFS(int l, int sum) {

        //레벨과 N 같으면
        if (l== N) {
            if (sum == S)
                count++;
            return;
        }
        //레벨은 똑같이 증가
        DFS(l + 1, sum + ar[l]); // 1. 해당 인덱스 더함
        DFS(l + 1, sum); // 2. 해당 인덱스 더하지않음
    }
}
