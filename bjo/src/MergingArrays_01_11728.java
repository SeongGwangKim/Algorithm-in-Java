import java.io.*;
import java.util.*;

public class MergingArrays_01_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.valueOf(NM[0]);
        int M = Integer.valueOf(NM[1]);

        String[] NArray = br.readLine().split(" ");
        String[] MArray = br.readLine().split(" ");

        int[] answerArray = new int[N+M];
        for(int i=0; i<N; i++){
            answerArray[i] = Integer.valueOf(NArray[i]);
        }

        for(int i=0; i<M; i++){
            answerArray[N+i] = Integer.valueOf(MArray[i]);
        }

        Arrays.sort(answerArray);

        for(int i=0; i<N+M; i++){
            bw.write(answerArray[i] + " ");
        }
        bw.flush();
    }
}
