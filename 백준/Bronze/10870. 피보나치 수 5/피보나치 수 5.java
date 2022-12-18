import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int [] fibo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        fibo = new int[N+1];

        System.out.println(fibonachi(N));
    }

    private static int fibonachi(int n) {
        if(n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else {
            return fibo[n] = fibonachi(n-1) +  fibonachi(n-2);
        }

    }
}
