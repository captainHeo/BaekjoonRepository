import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb= new StringBuffer();
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<10; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0;
        sum += q.poll(); sum += q.poll(); sum += q.poll();
        sb.append(sum + " ");

        sum = 0;
        q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<10; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }
        sum += q.poll(); sum += q.poll(); sum += q.poll();
        sb.append(sum + " ");

        System.out.println(sb);
    }
}