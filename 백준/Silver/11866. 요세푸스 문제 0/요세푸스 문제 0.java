import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer("<");
        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++) {
            q.add(i);
        }

        int count = K;
        int num;
        while (!q.isEmpty()) {

            num = q.poll();
            count--;

            //K번째 사람을 제거했다면
            //큐에 다시 집어넣지 않고 출력
            //다시 count 에 K 대입
            if(count == 0) {
                sb.append(num + ", ");
                count = K;
            } else {
                q.offer(num);
            }
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}
