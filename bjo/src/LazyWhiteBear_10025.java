import java.io.*;

public class LazyWhiteBear_10025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input N, K를 받고 x 배열의 최대값으로 생성하여 해당 위치에 얼음양을 배열에 담음
        String[] NK = br.readLine().split(" ");
        int N = Integer.valueOf(NK[0]);
        int K = Integer.valueOf(NK[1]);

        int[] xArray = new int[1000001];

        for(int i=0; i<N; i++){
            String[] temp_g_x = br.readLine().split(" ");
            int g = Integer.valueOf(temp_g_x[0]);
            int x = Integer.valueOf(temp_g_x[1]);

            xArray[x] = g;
        }

        bw.write(getMaxIce(xArray, K) + "\n");
        bw.flush();
    }

    public static int getMaxIce(int[] xArray, int K){
        int answer = 0;
        int r = 0;
        int iceNum = 0;

        // 투 포인터를 사용하여 x를 x-K ~ x+K에 속한 얼음양들을 다 더하고 이동 시 이동한 위치의 얼음양을 빼서 최대값을 찾음
        for(int l=0; l<xArray.length; l++){
            while(r <= l + K && r < 1000001){
                iceNum += xArray[r];

                r += 1;
            }

            answer = Math.max(answer, iceNum);

            if(l-K >= 0){
                iceNum -= xArray[l-K];
            }
        }

        return answer;
    }
}
