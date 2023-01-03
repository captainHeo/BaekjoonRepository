import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx;
    static int[] dy;
    static Queue<Pair> qu;

    public static void main(String args[]) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        //그래프 크기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];//그래프
        visit = new boolean[n][m];//방문 확인
        qu = new LinkedList<>();

        //우 상 좌 하
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};

        // 배열값 세팅
        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작!
        int count = 0;
        int area = 0;
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                // 0이거나 방문한적이 있으면 생략.
                if(arr[i][j] == 0 || visit[i][j]){
                    continue;
                }
                // 그림 개수, 1이고, 방문을 하지 않았으므로 시작점이 되니까 +1
                count++;
                // 큐에 좌표를 넣어준다.
                qu.offer(new Pair(i, j));
                // 방문처리!
                visit[i][j] = true;
                // 넓이, 0이면 그림이 끊겼으므로 area = 0!
                area = 0;

                //큐에 값 있으면 반복
                while(!qu.isEmpty()){
                    Pair p = qu.poll();
                    // 넓이 +1
                    area++;

                    //해당 위치에서 우 상 좌 하 돌아가며
                    for(int k = 0; k < 4; k++){
                        int n_x = p.x + dx[k];
                        int n_y = p.y + dy[k];
                        //범위 벗어났으면 패스
                        if(n_x < 0 || n_x >= n || n_y < 0 || n_y >= m){
                            continue;
                        }
                        //해당 위치 값이 1이고 방문 안했다면 큐에 해당 위치 추가하고 방문 처리
                        if(arr[n_x][n_y] == 1 && !visit[n_x][n_y]){
                            qu.offer(new Pair(n_x, n_y));
                            visit[n_x][n_y] = true;
                        }
                    }
                }
                //그림 최대 넓이 갱신
                if(area > max){
                    max = area;
                }
            }

        }
        System.out.println(count);
        System.out.println(max);
    }

    public static class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
