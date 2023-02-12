import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;
        //상하좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(true) {
            //Integer 배열 큐, 베열에는 좌표인 x값과 y값 들어있음
            Queue<Integer[]> q = new LinkedList<>();
            q.add(new Integer[]{0,0});
            map[0][0]=-1;

            while(!q.isEmpty()) {
                //바깥공기 영역 구하기 !!
                //bfs 사용
                Integer[] tmp = q.poll();
                int x = tmp[0];
                int y = tmp[1];

                //상하좌우 스캔
                for(int i=0;i<4;i++) {
                    int nowx = x+dx[i];
                    int nowy = y+dy[i];
                    //범위 넘으면 패스
                    if(nowx<0||nowy<0||nowx>=N||nowy>=M) {
                        continue;
                    }
                    //바깥 공기로 변경하고 해당 위치 큐에
                    if(map[nowx][nowy]==0) {
                        map[nowx][nowy]=-1;
                        q.add(new Integer[] {nowx,nowy});
                    }
                }
            }

            //녹는 치즈 위치
            Queue<Integer> xx = new LinkedList<>();
            Queue<Integer> yy = new LinkedList<>();

            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    int cnt = 0;

                    //치즈면
                    if(map[i][j]==1) {
                        //상하좌우 탐색
                        for(int d=0;d<4;d++) {
                            int nowx = i+dx[d];
                            int nowy = j+dy[d];
                            //범위 벗어나면 패스
                            if(nowx<0||nowy<0||nowx>=N||nowy>=M) {
                                continue;
                            }

                            //바깥 공기라면 카운트 증가
                            if(map[nowx][nowy]==-1) {
                                cnt ++;
                                //두개이상이 비었다면 더이상 볼 필요 없으니 벗어나기
                                if(cnt>=2)
                                    break;
                            }
                        }
                        //격자면 녹아서 없어질 치즈 위치 저장
                        if(cnt>=2) {
                            xx.add(i);
                            yy.add(j);

                        }
                    }
                }
            }
            //녹아서 없어질 치즈의 좌표 없다면 종료
            if(xx.isEmpty()) {
                System.out.println(res);
                System.exit(0);
            }

            //종료가 되지 않았다는 것은 아직 치즈가 있다는 것.
            //없어질 치즈들을 없애주고, while문 진행

            //시간 증가
            res++;

            //없어질 치즈의 위치의 값 모두 0으로
            while(!xx.isEmpty()) {
                map[xx.poll()][yy.poll()] = 0;
            }
            //바깥 공기를 안쪽 공기로 변경
            for(int i = 0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(map[i][j]==-1) {
                        map[i][j]=0;
                    }
                }
            }
        }
    }
}