import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int W, H;
    static int answer = 0;
    //시계 방향으로 돌게
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int [][] ar;
        while (true) {
             st = new StringTokenizer(br.readLine());
             W = Integer.parseInt(st.nextToken());
             H = Integer.parseInt(st.nextToken());

             if(W==0 && H==0)
                 break;

             else {
                 //배열 생성
                 ar = new int[H][W];
                 for(int i=0; i<H; i++){
                     st = new StringTokenizer(br.readLine());
                     for(int j=0; j<W; j++){
                         ar[i][j] = Integer.parseInt(st.nextToken());
                     }
                 }

                 solution(ar);
                 sb.append(answer + "\n");
                 answer=0;
             }
        }
        System.out.println(sb);
    }

    //섬을 만날 때마다 DFS 호출하는
    public static void solution(int[][] board){

        //그래프 전부 탐색해 섬인 영역 찾는
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){

                //섬이면 섬 개수 추가, 해당 지점 0으로, 다시 방문 하지 않게
                if(board[i][j] == 1){
                    answer++;
                    board[i][j] = 0;
                    DFS(i, j, board);
                }
            }
        }
    }

    public static void DFS(int x, int y, int[][] board){

        //시계방향으로 도는
        for(int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            //범위 넘어가지 않고 이동한 위치도 섬 영역이면
            //해당 위치 값 0으로 해서 재방문하지 않게
            //그리고 DFS로 다시 뻗어나가는
            if(nx>=0 && nx<H && ny>=0 && ny<W){
                if(board[nx][ny] == 1) {
                    board[nx][ny]=0;
                    DFS(nx, ny, board);
                }
            }
        }
    }
}
