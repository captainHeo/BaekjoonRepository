import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int ar[] = new int[3];

        ar[0] = Integer.parseInt(st.nextToken());
        ar[1] = Integer.parseInt(st.nextToken());
        ar[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(ar);

        System.out.println(ar[0] + " " + ar[1] + " " + ar[2]);
    }
}
