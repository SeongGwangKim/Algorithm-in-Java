import java.io.*;

// 투포인터 방식
public class MergingArrays_04_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.valueOf(NM[0]);
        int M = Integer.valueOf(NM[1]);

        String[] NTempArray = br.readLine().split(" ");
        String[] MTempArray = br.readLine().split(" ");

        int[] NArray = new int[N];
        int[] MArray = new int[M];

        for(int i=0; i<N; i++){
            NArray[i] = Integer.valueOf(NTempArray[i]);
        }

        for(int i=0; i<M; i++){
            MArray[i] = Integer.valueOf(MTempArray[i]);
        }

        int[] answerArray = mergingArrays(NArray, MArray);

        for(int i=0; i<N+M; i++){
            bw.write(answerArray[i] + " ");
        }
        bw.flush();
    }

    public static int[] mergingArrays(int[] NArray, int[] MArray){
        int[] answerArray = new int[NArray.length + MArray.length];
        int NIndex = 0;
        int MIndex = 0;
        int answerIndex = 0;
        while (NIndex < NArray.length && MIndex < MArray.length) {
            if (NArray[NIndex] < MArray[MIndex])
                answerArray[answerIndex++] = NArray[NIndex++];
            else answerArray[answerIndex++] = MArray[MIndex++];
        }
        while (NIndex < NArray.length) {
            answerArray[answerIndex++] = NArray[NIndex++];
        }
        while(MIndex < MArray.length) {
            answerArray[answerIndex++] = MArray[MIndex++];
        }

        return answerArray;
    }
}
