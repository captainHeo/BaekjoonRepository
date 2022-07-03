import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("<");

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++) {
            queue.add(i);
        }

        int M = Integer.parseInt(st.nextToken());

        int count = 1;
        while (!queue.isEmpty()){

            count = M -1;

            while (count != 0) {
                queue.offer(queue.poll());
                count--;
            }
            sb.append(queue.poll());

            if(queue.size() != 0) sb.append(", ");
        }

        System.out.println(sb + ">");
    }
}
