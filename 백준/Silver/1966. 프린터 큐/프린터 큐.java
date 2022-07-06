import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            //문서 개수
            int N = Integer.parseInt(st.nextToken());

            //몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지
            int M = Integer.parseInt(st.nextToken());

            //정수형 배열을 타입으로 가진 연결리스트, 문서 인덱스와 중요도를 하나의 배열에 담음
            LinkedList<int[]> q = new LinkedList<>();

            //N개의 문서 중요도
            st = new StringTokenizer(br.readLine());

            //중요도가 적혀있는 N개의 문서 모두 리스트에 추가
            for (int i = 0; i < N; i++) {
                // {초기 위치, 중요도}
                q.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
            }

            // 출력 횟수
            int count = 0;

            // 한 케이스에 대한 반복문
            while (!q.isEmpty()) {

                int[] front = q.poll();	// 가장 첫 원소
                boolean isMax = true;	// front 원소가 가장 큰 원소인지를 판단하는 변수

                // 큐에 남아있는 원소들과 중요도를 비교
                for(int i = 0; i < q.size(); i++) {

                    //처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우
                    //첫번쨰 원소가 가장 크다면 이 조건문 걸리지 않고 반복횟수만큼 돌고
                    //isMax 참으로 유지되어 반복문 밖 조건문에도 걸리지 않음
                    if(front[1] < q.get(i)[1]) {

                        //뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.
                        //첫번쨰 원소인 뽑은 원소를 가장 뒤
                        //그 다음 큰 원소의 앞 원소들 다 뒤로
                        q.offer(front);
                        for(int j = 0; j < i; j++) {
                            q.offer(q.poll());
                        }

                        //front원소가 가장 큰 원소가 아니였으므로 false를 하고 탐색을 마침
                        isMax = false;
                        break;
                    }
                }

                // front 원소가 가장 큰 원소가 아니였으므로 다음 반복문으로 넘어감
                if(isMax == false) {
                    continue;
                }

                //front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서다.
                count++;
                if(front[0] == M) {	// 찾고자 하는 문서라면 해당 테스트케이스 종료
                    break;
                }

            }

            sb.append(count).append('\n');

        }
        System.out.println(sb);
    }

}
