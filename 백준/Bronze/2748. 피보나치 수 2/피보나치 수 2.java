import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long ar[] = new long[91];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Fibo();

        System.out.println(ar[N]);

    }

    static void Fibo() {

        ar[0] = 0; ar[1] = 1;

        for(int i=2; i<91; i++) {
            ar[i] = ar[i-1] + ar[i-2];
        }
    }
}
