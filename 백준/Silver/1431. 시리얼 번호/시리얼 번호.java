import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String [] ar = new String[N];

        for(int i=0; i<N; i++) {

            ar[i] = br.readLine();
        }

        Arrays.sort(ar, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    int sumA = 0, sumB = 0;
                    for(int i=0; i<o1.length(); i++) {
                        if(o1.charAt(i) >= 48 && o1.charAt(i) <= 59)
                            sumA += Integer.parseInt(Character.toString(o1.charAt(i)));

                        if(o2.charAt(i) >= 48 && o2.charAt(i) <= 59)
                            sumB += Integer.parseInt(Character.toString(o2.charAt(i)));
                    }
                    if(sumA == sumB)
                        return o1.compareTo(o2);

                    return sumA - sumB;
                }

                return o1.length() - o2.length();
            }
        });

        for(int i=0; i<ar.length; i++) {
            System.out.println(ar[i]);
        }
    }
}
