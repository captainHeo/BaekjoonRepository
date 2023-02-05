import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long [] ar = new long[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }
        long sum;
        for(int i=0; i<m; i++) {
            Arrays.sort(ar);
            sum = ar[0]+ar[1];
            ar[0] = sum;
            ar[1] = sum;
        }

        long ans = 0;

        for(int i=0; i<n; i++) {
            ans+=ar[i];
        }
        System.out.println(ans);
    }
}
