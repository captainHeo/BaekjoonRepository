import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<String> ar= new ArrayList<>();
        ArrayList<String> s = new ArrayList<>();

        for(int i=0; i<N; i++) {

            ar.add(br.readLine());
        }

        for(int i=0; i<M; i++) {

            s.add(br.readLine());
        }

        int sum=0;
        for(int i=0; i<M; i++) {

            String str = s.get(i);

            if(ar.contains(str)) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
