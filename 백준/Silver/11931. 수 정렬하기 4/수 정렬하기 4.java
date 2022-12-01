import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<N; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        StringBuffer sb = new StringBuffer();

        for(int i=0; i<N; i++) {
            sb.append(q.poll()+"\n");
        }
        System.out.println(sb);
    }
}
