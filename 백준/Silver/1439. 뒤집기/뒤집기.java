import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        //결국 중간중간 바꾼 것과, 모든 연속된 1 토큰을 0으로 바꾸거나 모든 연속된 0 토큰을 1로 바꾸는 것 중 작은쪽은 횟수가 똑같다.
        StringTokenizer st1 = new StringTokenizer(s, "0");
        StringTokenizer st0 = new StringTokenizer(s, "1");
        System.out.println(Math.min(st1.countTokens(), st0.countTokens()));
    }
}
