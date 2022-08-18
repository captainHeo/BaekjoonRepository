import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        String s;
        while(N-- >0) {
             s = br.readLine();

            if(s.equals("P=NP")) {

                sb.append("skipped\n");
            } else {

                st = new StringTokenizer(s,"+");

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                sb.append(a+b + "\n");
            }

        }

        System.out.println(sb);
    }
}
