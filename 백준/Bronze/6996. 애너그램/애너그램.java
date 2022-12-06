import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        String A, B;
        boolean result;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            A = st.nextToken();
            B = st.nextToken();

            result = anagram(A, B);

            sb.append(A + " & " + B + " ");
            if(result)
                sb.append("are anagrams.\n");
            else
                sb.append("are NOT anagrams.\n");
        }
        System.out.println(sb);
    }

    public static boolean anagram(String s1, String s2){

        HashMap<Character, Integer> map = new HashMap<>();

        //처음 입력한 문자열 문자 배열로 바꾸고 문자 하나씩 가져와 map에 넣기
        //처음 입력된 문자면 1로, 이전에 입력된 문자라면 +1
        for(char x : s1.toCharArray()){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        //두번째에 입력한 문자열을 문자 배열로 바꿔 문자 하나씩 가져온다
        //해당 문자가 키값으로 존재하지 않거나 해당 문자의 키값이 0이면
        for(char x : s2.toCharArray()){
            if(!map.containsKey(x) || map.get(x) == 0) {
                return false;
            }
            //해당 문자를 키로 갖고있는 값 -1
            map.put(x, map.get(x) - 1);
        }

        for (Character c : map.keySet()) {
            if(map.get(c) != 0)
                return false;
        }

        return true;
    }
}
