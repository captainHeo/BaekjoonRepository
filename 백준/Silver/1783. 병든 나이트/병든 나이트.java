import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());//2
        int M = Integer.parseInt(st.nextToken());//4

        int result = 0;

        if(N == 1) {
            // N이 1이면 이동하지 못해 시작지점만
            result = 1;
        }else if(N == 2) {
            // N이 2일 떈, 2번,3번 방향으로만 움직일 수 있음
            // 절대 4방향 다 움직일 수 없어서 최댓값은 4
            // 이동 횟수가 4번 이상이면 이동 방법을 모두 한 번씩 사용해야하니
            // 4번 이상이면 4를 받환하도록
            result = Math.min((M+1)/2, 4);
        }
        else if(N>=3){
            // M=7 부터 4방향 다 이동이 가능하다
            // 4방향 다 이동한 후에 y값이 1씩 증가하는 1번,4번 이동을 반복
            // 결국 M-2개의 칸을 갈 수 있다
            if(M < 7) {
                result = Math.min(M, 4);
            }else {
                result = M-2;
            }
        }

        System.out.println(result);
    }
}
