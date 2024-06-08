import java.io.*;
import java.util.*;

public class ManagingPocketMoney_6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.valueOf(NM[0]);
        int M = Integer.valueOf(NM[1]);

        int[] inputArray = new int[N];
        int sumMoney = 0;
        int maxMoney = 0;
        for(int i=0; i<N; i++){
            inputArray[i] = Integer.valueOf(br.readLine());
            sumMoney += inputArray[i];
            if(maxMoney < inputArray[i]){
                maxMoney = inputArray[i];
            }
        }

        bw.write(searchOptimalValue(inputArray, M, maxMoney, sumMoney) + "\n");
        bw.flush();

    }

    public static int searchOptimalValue(int[] inputArray, int M, int maxMoney, int sumMoney){
        int answer = 0;
        int l = maxMoney;
        int r = sumMoney;

        while(l <= r){
            int m = (l+r)/2;
            int cnt = 1;
            int balance = m;

            for(int i=0; i<inputArray.length; i++){

                if(balance < inputArray[i]){
                    cnt += 1;
                    balance = m;
                }
                balance -= inputArray[i];
            }

            // 인출 횟수가 적으면 용돈을 줄인다.
            if(cnt <= M){
                r = m - 1;
                answer = m;
            // 인출 횟수가 많으면 용돈을 늘린다.
            }else {
                l = m + 1;

            }

        }

        return answer;
    }

}
