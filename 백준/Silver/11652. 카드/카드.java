import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            Long num =Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        int max=0;
        // 가장 중복된 수 구하기
        ArrayList<Integer> list = new ArrayList<>(map.values());
        for(Integer val : list){

            if(max<val){
                max=val;
            }
        }

        PriorityQueue<Long> q = new PriorityQueue<>();
        //키에 해당하는 값이 가장 중복된 수와 같으면 키를 큐에 추가
        //가장 중복된 수가 여러 개 있을 수 있으니
        for(Long key : map.keySet()){
            if(max == map.get(key)){
                q.add(key);
            }
        }
        //가장 앞에꺼 출력
        System.out.println(q.poll());
    }
}
