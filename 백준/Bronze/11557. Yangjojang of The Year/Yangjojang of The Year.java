import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        HashMap<Integer, String> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        int T = Integer.parseInt(br.readLine());

        int N; String name; int num;
        for(int i=0; i<T; i++) {

            N = Integer.parseInt(br.readLine());

            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                name = st.nextToken();
                num = Integer.parseInt(st.nextToken());

                q.add(num);
                map.put(num, name);
            }

            sb.append(map.get(q.poll()) + "\n");

        }
        System.out.println(sb);
    }
}
