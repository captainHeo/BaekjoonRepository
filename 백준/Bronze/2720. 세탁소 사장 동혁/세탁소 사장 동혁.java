import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int [] coins = {25, 10, 5, 1};
        int [] coinCount = new int[4];

        int C;
        for(int i=0; i<T; i++) {

            C = Integer.parseInt(br.readLine());

            for(int j=0; j<coins.length; j++) {

                if(C/coins[j] > 0) {
                    coinCount[j] = C/coins[j];
                    sb.append(coinCount[j]+ " ");
                    C %= coins[j];
                } else {
                    sb.append(0+" ");
                }
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}
