import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int K, S[];
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {

            st = new StringTokenizer(br.readLine(), " ");

            K = Integer.parseInt(st.nextToken());

            if(K == 0) {
                break;
            } else{

                S = new int[K];
                visit = new boolean[K];

                for(int i=0; i<K; i++) {

                    S[i] = Integer.parseInt(st.nextToken());
                }

                DFS(0, 0);
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void DFS(int idx, int L) {

        if(L == 6) {

            for(int i=0; i<K; i++) {
                if(visit[i])
                    sb.append(S[i] + " ");
            }
            sb.append("\n");
        }
        if(idx == K)
            return;

        for(int i=idx; i<K; i++) {

            visit[i] = true;
            DFS(i+1, L+1);
            visit[i] = false;
        }

    }
}
