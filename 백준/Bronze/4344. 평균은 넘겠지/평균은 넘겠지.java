import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int [] ar;

        for(int i=0; i<C; i++) {
            double sum=0, avg, count = 0;
            st = new StringTokenizer(br.readLine());

            //학생 수
            int N = Integer.parseInt(st.nextToken());
            //배열 생성
            ar = new int[N];

            //점수 배열에 저장하고 합계 구하기
            for(int j=0; j<N; j++) {
                ar[j] = Integer.parseInt(st.nextToken());
                sum += ar[j];
            }

            avg = sum / N;

            for(int j=0; j<N; j++) {
                if(ar[j] > avg)
                    count++;
            }

            System.out.printf("%.3f%%\n",(count/N)*100);
        }
    }
}
