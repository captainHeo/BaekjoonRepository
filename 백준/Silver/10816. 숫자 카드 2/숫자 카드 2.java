import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        //카드 번호가 키, 해당 카드 번호의 개수가 값
        HashMap<Integer, Integer> map = new HashMap<>();

        //상근이가 가지고 있는 숫자 카드의 개수
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int cardNum1;
        //카드에 적혀있는 숫자 리스트에
        while (st.hasMoreTokens()) {

            cardNum1 = Integer.parseInt(st.nextToken());

            //카드 번호에 해당하는 개수 가져와 1 추가
            map.put(cardNum1, map.getOrDefault(cardNum1, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());

        //몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수
        st = new StringTokenizer(br.readLine());

        int cardNum2;

        while (st.hasMoreTokens()) {

            cardNum2 = Integer.parseInt(st.nextToken());

            if(map.get(cardNum2) != null) {
                sb.append(map.get(cardNum2) + " ");
            } else {
                sb.append(0+ " ");
            }
        }

        System.out.println(sb);
    }
}
