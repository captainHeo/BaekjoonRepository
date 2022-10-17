import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N;
    static long sum = 0;
    static int ar[];
    static int gcdAr[] = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        //테스트 케이스 수
        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            //숫자 개수
            N = Integer.parseInt(st.nextToken());
            ar = new int[N];//숫자 배열
            for(int j=0; j<N; j++) {

                ar[j] = Integer.parseInt(st.nextToken());
            }

            dfs(0,0);
            sb.append(sum + "\n");
            sum = 0;
        }
        System.out.println(sb);
    }

    private static void dfs(int S, int L) {

        if(L == 2) {
            sum += gcd(gcdAr[0], gcdAr[1]);
            return;
        } else {
            for(int i=S; i<N; i++) {
                gcdAr[L] = ar[i];
                dfs(i+1, L+1);
            }
        }
    }

    private static int gcd(int x, int y) {

        if(y == 0)
            return x;
        else
            return gcd(y, x%y);
    }
}