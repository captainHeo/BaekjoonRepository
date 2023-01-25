import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //끊어진 기타줄의 개수 N과 기타줄 브랜드 M개
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Min = Integer.MAX_VALUE;

        int [] packagePrice = new int[M];
        int [] individualPrice = new int[M];

        for(int i=0; i<M; i++) {

            st = new StringTokenizer(br.readLine());

            packagePrice[i] = Integer.parseInt(st.nextToken());
            individualPrice[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(packagePrice); Arrays.sort(individualPrice);
        
        Min = Math.min( ((N/6)+1) * packagePrice[0], N * individualPrice[0]);
        Min = Math.min(Min, ((N/6)) * packagePrice[0] + (N%6) * individualPrice[0]);

        System.out.println(Min);
    }
}
