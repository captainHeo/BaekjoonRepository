import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        while (!queue.isEmpty()) {

            System.out.println(queue.poll());
        }
    }
}
