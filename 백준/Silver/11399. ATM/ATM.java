import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int ar[];
        int N = Integer.parseInt(br.readLine());
        ar = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++) {

            ar[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ar);

        int sum = ar[0];
        for(int i=1; i<N; i++) {

            ar[i] += ar[i-1];
            sum += ar[i];
        }

        System.out.println(sum);
    }
}
