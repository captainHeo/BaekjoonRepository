import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//빗물이 고이기 위한 조건
//현재 블록의 높이보다 높은 블록이 왼쪽에 있어야 한다.
//현재 블록의 높이보다 높은 블록이 오른쪽에 있어야 한다.
//첫, 마지막 블록에는 빗물이 고일 수 없다.
//인덱스 별로 모이는 빗물의 정보를 더해준 다음 출력해주면 된다.
// 현재 인덱스를 기준으로 왼쪽에서 가장 높은 블럭과 오른쪽에서 가장 높은 블럭을 구해준 다음,
// 현재 블럭이 두 블럭보다 낮은지 확인 후, 둘 중에 더 낮은 기둥을 기준으로 낮은 기둥에서
// 현재 기둥높이를 빼 주어 빗물이 고일 수 있는 높이를 계산해 주었다.
public class Main {
    static int h, w;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        //높이 너비 입력
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        //너비만큼 높이의 개수
        height = new int[w];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        //왼쪽 오른쪽 하나씩 남겨두고
        for(int i = 1; i < w - 1; i++) { //인덱스 별 모이는 빗물. 첫, 마지막 제외
            int left = 0;
            int right = 0;
            
            //현재 높이 기준에서 왼쪽 높이 모두 비교해 최고 높이 찾는다
            for(int j = 0; j < i; j++) {
                //현재 높이와 왼쪽 높이 비교해 큰 거 왼쪽 높이로
                left = Math.max(height[j], left);
            }

            //현재 높이 기준에서 오른쪽 높이 모두 비교해 최고 높이 찾는다
            for(int j = i + 1; j < w; j++) {
                right = Math.max(height[j], right);
            }

            //현재 위치 높이가 왼쪽 높이 최고값과 오른쪽 높이 최고값보다 작으면 
            if(height[i] < left && height[i] < right)
                //왼쪽 높이 최고값과 오른쪽 높이 최고값중 더 작은 값에서 현재 높이 뺀값을 결과에 더해준다
                result += Math.min(left, right) - height[i];
        }
        
        System.out.println(result);
    }
}
