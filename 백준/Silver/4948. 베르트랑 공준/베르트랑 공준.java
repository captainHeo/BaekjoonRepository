import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    static boolean prime[] = new boolean[246913];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        get_prime();

        int N; int count;

        while ((N = Integer.parseInt(br.readLine())) != 0) {

            count = 0;

            for(int i = N+1; i<=2 * N; i++) {

                if(!prime[i])
                    count++;
            }

            sb.append(count + "\n");
        }

        System.out.println(sb);
    }

    public static void get_prime() {

        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++) {

            if(prime[i])
                continue;

            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
