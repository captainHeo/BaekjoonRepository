import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    // N이 최대 100까지 입력 가능하므로
    public static Long[] seq = new Long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        seq[0] = 0L;
        seq[1] = 1L;
        seq[2] = 1L;
        seq[3] = 1L;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            sb.append( dp( Integer.parseInt( br.readLine() ) ) ).append('\n');
        }
        System.out.println(sb);
    }

    public static long dp(int N) {
        if(seq[N] == null) {
            seq[N] = dp(N - 2) +  dp(N - 3);
        }
        return seq[N];
    }

}
