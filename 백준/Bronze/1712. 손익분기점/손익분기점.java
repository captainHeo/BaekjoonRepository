import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());//고정 비용
        int B = Integer.parseInt(st.nextToken());//노트북 생산 비용
        int C = Integer.parseInt(st.nextToken());//노트북 판매가

        //노트북 생산 비용이 고정 비용보다 크거나 같으면
        //손익분기점이 존재할 수 없다
        if(C <= B) {
            System.out.println(-1);
        } else{
            int count = (A/(C - B)) + 1;
            System.out.println(count);
        }
    }
}

