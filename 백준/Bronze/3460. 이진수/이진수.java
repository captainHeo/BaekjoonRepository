import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        String s;
        while (T-- > 0) {

            s = (Integer.toBinaryString(Integer.parseInt(br.readLine())));

            for(int i=s.length()-1; i>=0; i--) {

                if(s.charAt(i) == '1'){

                    sb.append(s.length()-i-1 + " ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
