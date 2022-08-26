import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] ar;

        String s = br.readLine();

        ar = new String[s.length()];
        ar[0] = s;

        for(int i=1; i<s.length(); i++) {

            ar[i] = s.substring(i, s.length());
        }

        Arrays.sort(ar, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return o1.compareTo(o2);
            }
        });

        for(int i=0; i<s.length(); i++) {

            System.out.println(ar[i]);
        }
    }
}
