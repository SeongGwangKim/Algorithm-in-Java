import java.io.*;
import java.util.*;

public class CuttingCable_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] KN = br.readLine().split(" ");
        int K = Integer.valueOf(KN[0]);
        int N = Integer.valueOf(KN[1]);

        int[] inputArray = new int[K];
        for(int i=0; i<K; i++){
            inputArray[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(inputArray);

        bw.write(maxSearchLength(inputArray, N) + "\n");

        bw.flush();

    }

    public static int maxSearchLength(int[] inputArray, int N){
        int answer = 0;
        long l = 0;
        long r = inputArray[inputArray.length-1];

        while(l <= r){
            long m = (l+r)/2;
            if(m == 0){
                m = 1;
            }else{
                m = m;
            }
            int cnt = 0;

            for(int i=0; i<inputArray.length; i++){
                cnt += (inputArray[i]/m);
            }

            if(cnt < N){
                r = m -1;
            }else if(cnt >= N){
                l = m + 1;
                answer = (int) m;
            }
        }
        return answer;
    }

}
