import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static ArrayList<Gem> jemList = new ArrayList<>();
    static int[] backPack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //보석과 가방 개수
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //가방의 정보가 들어있는 리스트 크기
        backPack = new int[K];

        //각 보석의 무게와 가격
        int M, V;
        for(int i=0; i<N; i++) {

            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            jemList.add(new Gem(M, V));
        }

        //무게 높은 순으로 정렬, 무게 같으면 가격이 더 낮은 순으로
        jemList.sort(new Comparator<Gem>() {
            @Override
            public int compare(Gem o1, Gem o2) {
                if(o1.weight == o2.weight) {
                    return o2.num - o1.num;
                }
                return o1.weight - o2.weight;
            }
        });

        //가방에 담을 수 있는 최대 무게
        int C;
        for(int i=0; i<K; i++) {

            C = Integer.parseInt(br.readLine());
            backPack[i] = C;
        }
        //가방 무게 오름차순 정렬
        Arrays.sort(backPack);

        //보석 인덱스
        int gem_idx = 0;
        //보석 리스트 크기
        int gem_size = jemList.size();
        //큐는 가격 내림차순으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //보석 훔칠 수 있는 가격 합
        long answer = 0;

        //가방 리스트에서 가방 무게 하나씩 가져오기
        for(int bag : backPack)
        {
            //막연하게 보석 개수만큼 반복하는게 아닌
            
            //보석 인덱스가 보석 리스트보다 크지 않고
            //보석 리스트에서 가져온 무게가 가방 무게보다 작거나 같으면
            //큐에 보석 가격 추가하면서 보석 인덱스 증가
            while(gem_idx < gem_size && bag >= jemList.get(gem_idx).weight)
                pq.add(jemList.get(gem_idx++).num);

            //큐 비어있지 않으면 큐에서 보석 가격 꺼내 가격 합에 더해주기
            if(!pq.isEmpty())
                answer += pq.poll();
        }
        System.out.println(answer);

    }

    static class Gem{
        int weight;
        int num;

        public Gem(int weight, int num) {
            this.weight = weight;
            this.num = num;
        }
    }
}
