import java.io.*;
import java.util.*;

public class InstallingRouter_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NC = br.readLine().split(" ");
        int N = Integer.valueOf(NC[0]);
        int C = Integer.valueOf(NC[1]);
        int[] inputArray = new int[N];

        for(int i=0; i<N; i++){
            inputArray[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(inputArray);

        bw.write(parameterSearch(inputArray, C) + "\n");
        bw.flush();

    }

    public static boolean isPosible(int[] inputArray, int m, int C){
        boolean bool = false;
        int len = inputArray[0];
        int cnt = 1;
        for(int i=1; i<inputArray.length; i++){
            int temp = inputArray[i] - len;

            if( temp >= m){
                cnt += 1;
                len = inputArray[i];
            }

        }

        // cnt가 목표값보다 작거나 같으면 true
        if(cnt >= C){
            bool = true;
        }

        return bool;
    }

    public static int parameterSearch(int[] inputArray, int C){
        int answer = -1;
        int l = 1;
        int r = inputArray[inputArray.length-1];

        while(l <= r){
            int m = (l+r)/2;

            if(isPosible(inputArray, m, C)){
                answer = m;
                l = m +1;
            }else{
                r = m -1;
            }

        }

        return answer;
    }

}
