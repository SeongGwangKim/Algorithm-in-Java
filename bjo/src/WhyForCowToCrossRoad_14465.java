import java.io.*;
import java.util.*;

public class WhyForCowToCrossRoad_14465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input N, K, B 받기
        String[] NKB = br.readLine().split(" ");
        int N = Integer.valueOf(NKB[0]);
        int K = Integer.valueOf(NKB[1]);
        int B = Integer.valueOf(NKB[2]);

        // 숫자가 1부터 시작하므로 0부터 시작인 Array에 +1을 해줌
        int[] NArray = new int[N+1];
        Arrays.fill(NArray, 1);

        // 1이면 정상 0이면 고장으로 2번째 줄부터 고장난 위치들을 0으로 변경
        for(int i=0; i<B; i++){
            int temp = Integer.valueOf(br.readLine());
            NArray[temp] = 0;
        }

        bw.write(getMinRepair(NArray, K) + "\n");
        bw.flush();

    }

    public static int getMinRepair(int[] NArray, int K){
        // min 값을 구하기 때문에 나올 수 있는 최대 수에 +1로 초깃값 설정
        int answer = 100001;
        int repairCnt = 0;
        int serialVal = 0;
        int r = 1;

        // 투포인터로 r을 1씩 증가시키며 신호등의 상태를 확인하고 그에 따라 수리할 신호등 갯수를 파악하며 최솟값 찾음
        for(int l=1; l<NArray.length; l++){
            while(serialVal < K && r < NArray.length){
                if(NArray[r] == 1){
                    serialVal += 1;
                }else if(NArray[r] == 0){
                    serialVal += 1;
                    repairCnt += 1;
                }
                r += 1;
            }

            if(serialVal == K){
                answer = Math.min(answer, repairCnt);
            }

            if(NArray[l] == 1){
                serialVal -= 1;
            }else if(NArray[l] == 0){
                serialVal -= 1;
                repairCnt -= 1;
            }
        }

        return answer;
    }
}
