import java.io.*;
import java.util.*;

public class SelectNumber_2230_BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.valueOf(NM[0]);
        int M = Integer.valueOf(NM[1]);

        int[] A = new int[N];

        for(int i=0; i<N; i++){
            A[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(A);

        bw.write(searchMinDiff(A, M) + "\n");
        bw.flush();

    }

    public static int searchMinDiff(int[] A, int M){
        int answer = 2000000001;

        for(int i=0; i<A.length; i++){
            int l = 0;
            int r = A.length -1;
            int currentDiff = 0;

            while(l <= r){
                int m = (l + r)/2;
                currentDiff = A[m] - A[i];

                if(currentDiff >= M){
                    answer  = Math.min(answer, currentDiff);

                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }
        }

        return answer;
    }

}
