import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> ar = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++) {

            ar.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(ar, Collections.reverseOrder());

        System.out.println(ar.get(K-1));
    }
}
