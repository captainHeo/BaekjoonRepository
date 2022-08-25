import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {

            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {

            B.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(A);

        int S = 0;
        for(int i=0; i<N; i++) {

            S += A.get(i) * Collections.max(B);
            B.remove(Collections.max(B));
        }

        System.out.println(S);
    }

}
