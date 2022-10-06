import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = gcd(n,m);

        System.out.println(n/result + ":" + m/result);
    }

    private static int gcd(int x, int y) {

        if (y == 0)
            return x;
        else
            return gcd(y, x%y);

    }
}
