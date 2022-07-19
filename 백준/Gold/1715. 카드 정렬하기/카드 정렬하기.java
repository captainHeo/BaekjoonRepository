import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> q = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            q.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while (q.size() > 1) {
            int num1 = q.poll();
            int num2 = q.poll();

            sum += num1 + num2;
            q.add(num1 + num2);
        }

        System.out.println(sum);
    }
}
