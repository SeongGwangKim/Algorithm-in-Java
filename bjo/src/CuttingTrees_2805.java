import java.io.*;
import java.util.*;

public class CuttingTrees_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.valueOf(NM[0]);
        int M = Integer.valueOf(NM[1]);

        String[] tempArray = br.readLine().split(" ");
        int[] inputArray = new int[N];
        for (int i = 0; i < N; i++) {
            inputArray[i] = Integer.valueOf(tempArray[i]);
        }

        Arrays.sort(inputArray);

        bw.write(sumTreeLength(inputArray, M) + "\n");
        bw.flush();

    }

    public static int sumTreeLength(int[] inputArray, int M){
        int answer = -1;
        int l = 0;
        int r = inputArray[inputArray.length-1];

        while(l <= r){
            long totalTreeLength = 0;
            int m = (l+r) / 2;

            for(int i=0; i<inputArray.length; i++){
                int temp = inputArray[i] - m;
                if(temp <= 0){
                    totalTreeLength += 0;
                }else{
                    totalTreeLength += temp;
                }
            }

            if(totalTreeLength < M){
                r = m - 1;
            }else if(totalTreeLength >= M){
                l = m + 1;
                answer = m;
            }
        }


        return answer;
    }

}
