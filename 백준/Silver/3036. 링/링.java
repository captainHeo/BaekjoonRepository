import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        int ring = Integer.parseInt(st.nextToken());
        int otherRing = 0;
        int gcd;
        while (st.hasMoreTokens()) {

            otherRing = Integer.parseInt(st.nextToken());
            gcd = gcd(ring, otherRing );

            sb.append(ring/gcd + "/" + otherRing/gcd + "\n");
        }

        System.out.println(sb);
    }

    private static int gcd(int x, int y) {

        if(y == 0)
            return x;
        else
            return gcd(y, x%y);
    }
}
