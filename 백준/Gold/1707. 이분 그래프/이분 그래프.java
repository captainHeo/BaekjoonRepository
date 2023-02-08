import java.io.*;
import java.util.*;

public class Main {
    static int v, e;
    static ArrayList<Integer>[] al;
    static int visit[];
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());//정점
            e = Integer.parseInt(st.nextToken());//간선
            visit = new int[v+1];//방문 여부
            al = new ArrayList[v+1];//그래프 생성

            //정점 개수만큼
            for(int j = 0; j <= v; j++)
                al[j] = new ArrayList<Integer>();

            int p1, p2;
            for(int k = 0; k < e; k++) {
                st = new StringTokenizer(br.readLine());
                //서로 연결된 정점 받기
                p1 = Integer.parseInt(st.nextToken());
                p2 = Integer.parseInt(st.nextToken());

                //입력한 정점 서로 연결
                al[p1].add(p2);
                al[p2].add(p1);
            }
            grouping();
        }
        System.out.println(sb);
    }

    public static void grouping() {
        Queue<Integer> q = new LinkedList<Integer>();

        //정점 개수만큼 반복
        for(int i = 1; i <= v; i++) {
            //해당 정점 방문하지 않았다면
            if(visit[i] == 0) {
                //큐에 추가하고 방문 처리
                //처음 방문한 정점은 1로 값을
                q.add(i);
                visit[i] = 1;
            }

            //큐 비어있지 않으면 반복
            while(!q.isEmpty()) {
                //큐에 있는 정점 꺼내기
                int now = q.poll();

                //해당 정점과 얀걀되어 있는 정점의 개수만큼 반복
                for(int j = 0; j < al[now].size(); j++) {
                    //연결되어 있는 정점 방문하지 않았다면 큐에 추가
                    if(visit[al[now].get(j)] == 0) {
                        q.add(al[now].get(j));
                    }

                    //연결되어 있는 정점과 현재 정점의 색이 같다면 이분 그래프가 아니다
                    if(visit[al[now].get(j)] == visit[now]) {
                        sb.append("NO\n");
                        return;
                    }

                    //현재 정점이 1이고 연결된 정점이 방문한 상태가 아니라면
                    if(visit[now] == 1 && visit[al[now].get(j)] == 0)
                        //연결된 정점 2로
                        visit[al[now].get(j)] = 2;
                    //현재 정점이 2고 연결된 정점이 방문한 상태가 아니라면
                    else if(visit[now] == 2 && visit[al[now].get(j)] == 0)
                        //연결된 정점 1로
                        visit[al[now].get(j)] = 1;
                }
            }
        }

        sb.append("YES\n");
    }

}