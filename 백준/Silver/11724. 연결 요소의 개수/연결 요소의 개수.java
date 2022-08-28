import java.io.*;
import java.util.*;

public class Main {

    //정수형 리스트 타입의 배열
    static ArrayList<Integer>[] adjList;
    //방문여부
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];
        visited = new boolean[n+1];

        int vertex1, vertex2, answer = 0;

        for(int i = 1; i < n+1; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            vertex1 = Integer.parseInt(st.nextToken());
            vertex2 = Integer.parseInt(st.nextToken());
            
            //반대 정점도 이어져있다는걸 의미
            adjList[vertex1].add(vertex2);
            adjList[vertex2].add(vertex1);
        }

        for(int i = 1; i < n+1; i++) {
            //방문하지 않았따면 
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    static void dfs(int v){
        
        //방문했다면
        if(visited[v]) {
            return;
        }
        
        //방문하지 않았다면 방문 체크
        visited[v] = true;
        
        //해당 정점에 이어져있는 정점들 하나씩 방문했는지 체크
        for(int i : adjList[v]){
            if(!visited[i]) {
                dfs(i);
            }
        }
    }

}
