import java.io.*;
import java.util.*;

public class SelectNumber_2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.valueOf(NM[0]);
        int M = Integer.valueOf(NM[1]);

        int[] inputArray = new int[N];

        for(int i=0; i<N; i++){
            inputArray[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(inputArray);

        bw.write(searchMinDiff(inputArray, M) + "\n");
        bw.flush();

    }

    public static int searchMinDiff(int[] inputArray, int M){
        int answer = 2000000001;
        int rightIndex = 0;
        int currentDiff = 0;

        for(int l=0; l<inputArray.length; l++){
            while(inputArray[rightIndex] - inputArray[l] < M && rightIndex < inputArray.length-1){
                rightIndex += 1;
            }

            currentDiff = inputArray[rightIndex] - inputArray[l];

            if(currentDiff >= M){
                answer = Math.min(answer, currentDiff);
            }
        }

        return answer;
    }

}
