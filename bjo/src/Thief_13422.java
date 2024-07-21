import java.io.*;
import java.util.*;

public class Thief_13422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.valueOf(br.readLine());

        for(int i=0; i<T; i++){
            String[] NMK = br.readLine().split(" ");
            int N = Integer.valueOf(NMK[0]);
            int M = Integer.valueOf(NMK[1]);
            int K = Integer.valueOf(NMK[2]);

            String[] inputArray = br.readLine().split(" ");
            bw.write(getPossibleCount(inputArray, M, K) + "\n");

        }
        bw.flush();


    }

    public static int getPossibleCount(String[] inputArray, int M, int K){
        int answer = 0;
        int r = 0;
        int MCnt = 0;
        int KCnt = 0;

        if(inputArray.length == M){
            int temp = 0;
            for(int i=0; i<inputArray.length; i++){
                temp += Integer.valueOf(inputArray[i]);
            }
            if(temp < K){
                answer = 1;
            }
        }else{
            for(int l=0; l<inputArray.length; l++){
                while(r < inputArray.length && MCnt < M && KCnt < K){
                    if(KCnt + Integer.valueOf(inputArray[r]) >= K){
                        break;
                    }else{
                        KCnt += Integer.valueOf(inputArray[r]);
                        MCnt += 1;
                        r = (r+1)%inputArray.length;
                    }

                }
                if(MCnt == M && KCnt < K){
                    answer += 1;
//                    System.out.println(l +"=========" +KCnt);
                }

                MCnt -= 1;
                KCnt -= Integer.valueOf(inputArray[l]);

            }
        }

        return answer;
    }
}
