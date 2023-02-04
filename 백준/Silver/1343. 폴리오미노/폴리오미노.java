import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String res = "";

        res = poliomino(s);

        System.out.println(res);
    }

    private static String poliomino(String s) {
        String ans = "";
        String A = "AAAA", B = "BB";

        //xxxx 면 AAAA 로 변경, xx 면 BB 로 변경
        s = s.replaceAll("XXXX", A);
        ans = s.replaceAll("XX", B);

        //변경하고 남아있는 x가 있다면
        if (ans.contains("X")) {
            ans = "-1";
        }

        return ans;
    }
}