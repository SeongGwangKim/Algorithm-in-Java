import java.io.*;

// 배열에 들어갈 수 있는 최대 정수까지 배열을 정의해서 푸는 방법 -> 시간 초과
public class MergingArrays_02_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.valueOf(NM[0]);
        int M = Integer.valueOf(NM[1]);

        String[] NArray = br.readLine().split(" ");
        String[] MArray = br.readLine().split(" ");

        int[] answerArray = new int[1000000001];
        for(int i=0; i<N; i++){
            answerArray[Integer.valueOf(NArray[i])]++;
        }

        for(int i=0; i<M; i++){
            answerArray[Integer.valueOf(MArray[i])]++;
        }

        for(int i=0; i<1000000001; i++){
            while(answerArray[i] > 0 ){
                bw.write(i + " ");
                answerArray[i] -= 1;
            }
        }
        bw.flush();
    }
}
