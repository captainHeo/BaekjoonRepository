import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int alpha[] = new int [123];

        for(int i = 97; i<=122; i++) {

            alpha[i] = -1;
        }

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int N = 0;

        for(int i=0; i<S.length(); i++) {
            if(alpha[(int) S.charAt(i)] == -1) {
                alpha[(int) S.charAt(i)] = N;
            }
            N++;
        }

        for(int i = 97; i<=122; i++) {

            sb.append(alpha[i] + " ");
        }

        System.out.println(sb);
    }
}
