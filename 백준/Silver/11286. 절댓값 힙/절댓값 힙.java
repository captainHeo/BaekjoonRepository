import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());

        Queue<Heap> q = new PriorityQueue<>(new Comparator<Heap>() {
            @Override
            public int compare(Heap o1, Heap o2) {
                if(o1.abs == o2.abs)
                    return o1.num - o2.num;

                return o1.abs - o2.abs;
            }
        });

        for(int i=0; i<N; i++) {

            int num = Integer.parseInt(br.readLine());

            if(num ==0) {
                if(q.isEmpty())
                    sb.append(0 + "\n");
                else
                    sb.append(q.poll().num +"\n");
            } else {
                q.add(new Heap(num, Math.abs(num)));
            }
        }
        System.out.println(sb);
    }

    static class Heap {
        int num;
        int abs;

        public Heap(int num, int abs) {
            this.num = num;
            this.abs = abs;
        }
    }
}
