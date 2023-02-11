import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class IceBerg {
        int x;
        int y;

        IceBerg(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dX = { -1, 0, 1, 0 };
    static int[] dY = { 0, 1, 0, -1 };

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //지도에 값 채우기
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int cnt = 0;

        // 빙하가 2개 이상 분리될 경우 반복문을 종료.
        // 빙하가 다 녹아버렸을 경우, 0을 출력.
        while ((cnt = SeparateNum()) < 2) {
            if (cnt == 0) {
                ans = 0;
                break;
            }

            //빙하 영역이 2개보다 작으면 다 녹았는지 확인하고 녹지 않았다면 녹이기
            Melt();
            ans++;
        }

        System.out.println(ans);
        br.close();
    }

    // 빙하가 분리된 개수를 구하는 함수.
    public static int SeparateNum() {
        boolean[][] visited = new boolean[N][M];

        int cnt = 0;
        //지도를 전부 돌면서
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //빙산이 있고 방문하지 않았다면
                if (map[i][j] != 0 && !visited[i][j]) {
                    //방문 처리, 빙산 영역 개수 증가, DFS 탐색
                    cnt++;
                    visited[i][j] = true;
                    DFS(i, j, visited); // DFS 방식을 통해 총 몇 개의 빙하로 나누어졌는지 구한다.
                }
            }
        }
        //빙산 영역의 개수 반환
        return cnt;
    }

    public static void DFS(int x, int y, boolean[][] visited) {

        int dx, dy;
        //해당 위치에서 상하좌우 탐색하며
        for (int i = 0; i < 4; i++) {
            dx = x + dX[i];
            dy = y + dY[i];

            //범위 넘어가지 않고 빙산이고 방문하지 않았다면
            if (dx >= 0 || dy >= 0 || dx < N || dy < M) {
                if (map[dx][dy] != 0 && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    DFS(dx, dy, visited);
                }
            }
        }
    }

    // 빙하를 녹이는 함수.
    public static void Melt() {
        Queue<IceBerg> q = new LinkedList<>();

        // visited 배열을 만드는 이유

        // visited 배열이 없다면,
        // 만약 1 2 가 있는 상태에서 1이 먼저 녹아서 0이 될 경우
        // 2는 녹아서 없어진 1 자리도 0이라고 판단하여
        // 필요 이상으로 더 많은 값을 녹이게 되어 버림.
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //빙산이면 위치를 큐에 추가하고 방문 처리
                if (map[i][j] != 0) {
                    q.offer(new IceBerg(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int dx, dy;
        while (!q.isEmpty()) {
            //쿠에서 빙산 위치 꺼내기
            IceBerg ice = q.poll();

            int seaNum = 0; // 빙하 상하좌우에 존재하는 바다 영역의 수.

            //해당 위치에서 상하좌우 돌면서
            for (int i = 0; i < 4; i++) {
                dx = ice.x + dX[i];
                dy = ice.y + dY[i];

                //이동한 위치가 범위 벗어나지 않고, 방문하지 않고 바닷물이라면
                if (dx >= 0 || dy >= 0 || dx < N || dy < M) {
                    if (!visited[dx][dy] && map[dx][dy] == 0) {
                        seaNum++;
                    }
                }
            }

            //바닷물 개수가 빙산의 높이보다 크다면
            if (map[ice.x][ice.y] - seaNum < 0) {
                map[ice.x][ice.y] = 0;
            } else {
                map[ice.x][ice.y] -= seaNum;
            }
        }
    }
}
