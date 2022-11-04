import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T, k=0, h=0;
    static int apart[][] = new int[15][15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        //0층에는 호수 숫자만큼 거주자
        for (int i=1; i<15; i++) {
            apart[0][i] = i;
        }

        liveNum();

        T = Integer.parseInt(br.readLine());

        for(int j=0; j<T; j++){

            k = Integer.parseInt(br.readLine());
            h = Integer.parseInt(br.readLine());

            sb.append(apart[k][h]).append("\n");
        }

        System.out.println(sb);
    }

    public static void liveNum() {

        for(int i=1; i<15; i++) {

            for(int j=1; j<15; j++) {

                for(int k=1; k<=j; k++) {

                    //1 층 1호는 0층 1호부터
                    apart[i][j] += apart[i-1][k];
                }
            }
        }
    }
}
