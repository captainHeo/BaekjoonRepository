import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        ArrayList<Integer> ar;
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            ar = new ArrayList<>();

            while (st.hasMoreElements()) {

                ar.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(ar, Collections.reverseOrder());

            ar.remove(0); ar.remove(0);

            sb.append(ar.get(0) + "\n");
         }

        System.out.println(sb);
    }
}
