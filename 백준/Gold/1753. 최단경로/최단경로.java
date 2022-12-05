import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // INF 값 초기화
    static final int INF = Integer.MAX_VALUE;

    // 그래프를 표현 할 2차원 List
    static List<List<Node>> graph = new ArrayList<>();

    // 최단거리테이블을 표현 할 배열
    static int[] result;

    // 방문처리를 위한 배열이지만 저는 다른 방법으로 방문처리를 진행하겠습니다.
    //	static boolean[] vistied;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        //정점 개수 V, 간선 개수 E
        //1부터 V까지 정점이 존재
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        //시작 정점 번호
        int startIndex = Integer.parseInt(br.readLine());

        // 그래프 생성
        for (int i = 0; i < V+1; i++) {
            graph.add(new ArrayList<>());
        }
        // 최단거리테이블 생성
        result = new int[V+1];
        // 최단거리테이블 INF로 초기화
        Arrays.fill(result, INF);

        // 방문처리를 위한 배열 생성 (저는 사용하지 않습니다)
        // vistied = new boolean[Integer.parseInt(info[0])+1];

        // 각 간선 정보,
        //시작 정점, 끝 정점, 가중치
        int start, end, weight;
        for (int i = 0; i <E; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
        }

        // 문제에서 주어진 입력값을 바탕으로 다익스트라 알고리즘 수행
        dijkstra(startIndex);

        // 최단거리배열 결과를 출력, INF 면 INF 출력
        for (int i = 1; i < result.length; i++) {
            if(result[i] == INF) {
                sb.append("INF" + "\n");
            }else {
                sb.append(result[i] + "\n");
            }
        }
        System.out.println(sb);
    }

    // 다익스트라 알고리즘, 시작 인덱스 받음
    static void dijkstra(int index) {

        // 최단거리가 갱신 된 노드들을 담을 우선순위 큐 생성
        PriorityQueue<Node> pq =  new PriorityQueue<>(new Comparator<Node>() {
            // 최단거리 오름차순 정렬
            @Override
            public int compare(Node o1, Node o2) {
                return o1.distance - o2.distance;
            }
        });

        // 최단거리테이블의 시작 지점노드 값 0으로 갱신, 1에서 1가는데 0이므로
        result[index] = 0;

        // 우선순위 큐에 시작노드 넣기
        pq.offer(new Node(index, 0));

        // 우선순위 큐에 노드가 존재하면 계속 반복
        while(!pq.isEmpty()) {

            // 큐에서 노드 꺼내기
            Node node = pq.poll();

            // 꺼낸 노드의 인덱스 및 최단거리 비용 확인
            // nodeIndex 까지 최단거리가 distance 다
            int nodeIndex = node.index;
            int distance = node.distance;

            // 앞에서 주석처리했던 방문처리 배열을 사용해서 아래와 같이 방문처리하셔도 됩니다.
//			if(vistied[nodeIndex]) {
//				continue;
//			}else{
//				vistied[nodeIndex] = true;
//			}

            // 큐에서 꺼낸 거리와 최단거리테이블의 값을 비교해서 방문처리
            // 최단거리 테이블은 처음에 INF 로 초기화됨
            // 큐는 최단거리를 기준으로 오름차순 정렬, 가장 짧은거부터
            // 만약 현재 꺼낸 노드의 거리가 최단거리테이블의 값보다 크다면 해당 노드는 이전에 방문된 노드.
            // 최단거리테이블 값이 INF에서 다른 값으로 갱신되었기 때문
            // 그러므로 해당노드와 연결 된 노드를 탐색하지 않고 큐에서 다음 노드를 꺼냄
            if(distance > result[nodeIndex]) {
                continue;
            }

            // 최단거리테이블 값이 큐에서 꺼낸 거리값보다 크면

            // 큐에서 꺼낸 노드에서 이동 가능 한 노드들을 탐색
            for (Node linkedNode : graph.get(nodeIndex)) {
                // 해당노드를 거쳐서 다음 노드로 이동 할 때의 값이
                // 다음 이동노드의 최단거리테이블 값보다 작을 때
                if(distance + linkedNode.distance < result[linkedNode.index]) {
                    // if문의 조건을 만족했다면 최단거리테이블의 값을 갱신
                    result[linkedNode.index] = distance + linkedNode.distance;
                    // 갱신 된 노드를 우선순위 큐에 넣어
                    pq.offer(new Node(linkedNode.index, result[linkedNode.index]));
                }
            }
        }
    }

    // 우선순위 큐에서 정렬기준을 잡기위해 Comparable를 구현합니다.
    static class Node {
        int index;			// 노드 번호
        int distance;		// 이동 할 노드까지의 거리

        Node(int index, int distacne) {
            this.index = index;
            this.distance = distacne;
        }
    }
}
