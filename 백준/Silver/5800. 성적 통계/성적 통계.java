import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        ArrayList<Integer> ar;
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st; int N;
        for(int i=0; i<K; i++) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            ar = new ArrayList<>();
            for(int j=0; j<N; j++) {
                ar.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(ar, Comparator.reverseOrder());

            int differ = Integer.MIN_VALUE;
            for(int k=0; k<ar.size()-1; k++) {
                differ = Math.max(differ, ar.get(k) - ar.get(k+1));
            }
            sb.append("Class " + (i+1) +  "\n").append("Max " + ar.get(0))
                    .append(", Min " + ar.get(ar.size()-1)).append(", Largest gap " + differ + '\n');
        }

        System.out.println(sb);
    }
}
