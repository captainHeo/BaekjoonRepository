import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        //그래프 생성
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        //진입 차수 배열
        Building [] edgeCountAr = new Building[N+1];

        StringTokenizer st; int time;
        for(int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());

            //입력한 숫자 2개면 진입 차수 없음
            if(st.countTokens() == 2) {
                time = Integer.parseInt(st.nextToken());
                edgeCountAr[i] = new Building(i, time, 0);
            } else {
                //건물 건설 시간 먼저 빼놓기
                time = Integer.parseInt(st.nextToken());

                //진입 차수 개수
                int count=0;
                while(st.hasMoreTokens()) {
                    //이전에 지어야할 건물 번호인지 -1인지 확인하기 위한 값
                    int checkVal = Integer.parseInt(st.nextToken());

                    if(checkVal != -1) {
                        count++;
                        graph.get(checkVal).add(i);
                    }
                }
                edgeCountAr[i] = new Building(i, time, count);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        //진입 차수 0인 노드는 큐에
        for(int i=1; i<N+1; i++) {
            if(edgeCountAr[i].edgeCount ==0)
                q.offer(i);
        }

        int[] result = new int[N + 1];

        while (!q.isEmpty()) {
            int nodeNum = q.poll();

            //해당 건물을 다 짓고나면 지을 수 있는 건물 번호 리스트
            List<Integer> list = graph.get(nodeNum);

            for(int i=0; i<list.size(); i++) {
                int next = list.get(i);

                //진입차수 감소시키고 해당 노드의 건설 시간에 이전 노드의 건설 시간 추가
                edgeCountAr[next].edgeCount--;

                result[next] = Math.max(result[next], result[nodeNum] + edgeCountAr[nodeNum].time);

                if (edgeCountAr[next].edgeCount == 0) {
                    q.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append((result[i] + edgeCountAr[i].time) + "\n");
        }

        System.out.println(sb);
    }

    static class Building{
        int num;//건물 번호
        int time;//건물 건설 시간
        int edgeCount;//진입 차수

        public Building(int num, int time, int edgeCount) {
            this.num = num;
            this.time= time;
            this.edgeCount = edgeCount;
        }
    }
}
