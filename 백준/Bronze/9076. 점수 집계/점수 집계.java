import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> ar;

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(T-->0) {

            st = new StringTokenizer(br.readLine());

            ar = new ArrayList<>();
            while(st.hasMoreTokens()) {
                ar.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(ar);
            ar.remove(0); ar.remove(ar.size()-1);

            if(ar.get(ar.size()-1) - ar.get(0)  >= 4) {
                sb.append("KIN\n");
                continue;
            } else {
                sb.append(ar.get(0) + ar.get(1) +  ar.get(2) + "\n");
            }
        }

        System.out.println(sb);
    }
}
