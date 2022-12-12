import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] numCount = new int[10];

        long result = 1;
        for(int i=0; i<3; i++) {

            result *= Integer.parseInt(br.readLine());
        }

        for (char c : String.valueOf(result).toCharArray()) {

            numCount[c - 48]++;
        }

        for (int i : numCount) {
            System.out.println(i);
        }
    }
}