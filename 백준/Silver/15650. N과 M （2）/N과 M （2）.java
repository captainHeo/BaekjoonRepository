import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int combi[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());//1부터 N까지 숫자
        M = Integer.parseInt(st.nextToken());//조합 개수

        combi = new int[M];

        DFS(0, 1);
    }

    //L은 level 깊이임, s는 출력할 배열에 넣을 숫자
    private static void DFS(int L, int s) {

        //깊이가 조합 개수와 같으면
        if(L == M) {

            for (int i : combi) {
                System.out.print(i + " ");
            }
            System.out.println();
            
        } else {
            //1부터 N까지 숫자
            for(int i=s; i <= N; i++){
                //출력할 배열에 넣고
                combi[L] = i;
                //레벨 높이고 출력할 배열에 넣을 숫자도 증가
                DFS(L+1, i + 1);
            }
        }
    }

}
