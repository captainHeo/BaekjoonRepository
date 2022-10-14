import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    //좌 상 우 하
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int[][] board, dis;
    static int n, m;
    static Queue<Point> Q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken());//열
        n=Integer.parseInt(st.nextToken());//행

        board = new int[n][m];
        dis = new int[n][m];

        //그래프를 입력.
        for(int i=0; i<n; i++){

            st = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++){

                board[i][j]=Integer.parseInt(st.nextToken());

                //익은 토마토면 큐에 미리 넣는다
                if(board[i][j]  == 1)
                    Q.offer( new Point(i, j));
            }
        }

        BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;

        //원래 토마토 입력했던 그래프에서 다 돌면서 확인
        //0인거 있으면 덜 익은 토마토 있는 것이니 실패
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 0)
                    flag=false;
            }
        }

        //모두 다 익었다면
        //dis 그래프에서 가장 큰 값 찾으면 그게 익은 날짜 수
        if(flag){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        }

        //안익었으면 -1 출력력
        else
            System.out.println(-1);
    }

    public static void BFS(){

        while(!Q.isEmpty()){

            //익은 토마토 위치 꺼냄
            Point tmp = Q.poll();

            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny= tmp.y + dy[i];

                //이동한 위치가 덜 익은 토마토이면
                if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny] == 0){
                    //익은 토마토로 바꾸고 큐에 추가
                    board[nx][ny]=1;
                    Q.offer(new Point(nx, ny));

                    //날짜를 구하는 그래프에는 익은 토마토의 값 0 + 1 해서
                    //익은 토마토로 변한 위치 값에 넣어주는
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    static class Point{

        public int x, y;

        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}

