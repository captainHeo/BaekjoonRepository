import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        //문제 개수, 번호가 낮은 문제부터 쉬운 문제
        int N = Integer.parseInt(st.nextToken());
        //먼저 푸는 것이 좋은 문제에 대한 정보의 개수
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<N+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int [] edgeCount = new int[N+1];

        int A, B;
        //A번 문제는 B번 문제보다 먼저 푸는 것이 좋다
        for(int i=0; i<M; i++) {

            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);

            //B 문제를 풀기전에 풀어야할 문제의 개수인 진입 차수 증가
            edgeCount[B]++;
        }

        Queue<Integer> q = new PriorityQueue<>();

        //진입 차수가 0인거 큐에
        for(int i=1; i<N+1; i++) {
            if(edgeCount[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int nodeNum = q.poll();

            //큐에서 꺼낸 먼저 푸는 것이 좋은 문제 출력
            sb.append(nodeNum+" ");

            //해당 문제를 풀은 후 풀 수 있는 문제 리스트 갖고옴
            List<Integer> list = graph.get(nodeNum);

            Collections.sort(list);
            for(int i=0; i< list.size(); i++) {
                //진입 차수 감소
                edgeCount[list.get(i)]--;

                if (edgeCount[list.get(i)] == 0) {
                    q.offer(list.get(i));
                }
            }
        }

        System.out.println(sb);
    }
}
