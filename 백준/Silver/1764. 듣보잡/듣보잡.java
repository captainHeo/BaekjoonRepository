import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        String[] inputs = br.readLine().split(" ");
//        int n = Integer.parseInt(inputs[0]);
//        int m = Integer.parseInt(inputs[1]);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String tmp = br.readLine();
            if(set.contains(tmp)){//입력한게 set에 포함되어 있으면 결과 리스트에 추가
                result.add(tmp);
            }
        }
        
        //알파벳 순서대로 정렬
        Collections.sort(result);

        // print result
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}
