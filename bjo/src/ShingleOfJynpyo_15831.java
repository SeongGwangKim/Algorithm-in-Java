import java.io.*;

public class ShingleOfJynpyo_15831 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NBW = br.readLine().split(" ");
        int N = Integer.valueOf(NBW[0]);
        int B = Integer.valueOf(NBW[1]);
        int W = Integer.valueOf(NBW[2]);

        String input = br.readLine();

        bw.write(searchMaxLength(input, B, W) + "\n");
        bw.flush();

    }

    public static int searchMaxLength(String input, int B, int W){
        int answer = 0;
        int BCnt = 0;
        int WCnt = 0;
        int r = -1;

        for(int l=0; l<input.length(); l++){
            while(BCnt <= B && r < input.length() - 1){
                r += 1;
                if(input.charAt(r) == 'B'){
                    BCnt += 1;
                }else if(input.charAt(r) == 'W'){
                    WCnt += 1;
                }

                if(BCnt <= B && WCnt >= W){
                    answer = Math.max(answer, r - l + 1);
                }
            }

            if(input.charAt(l) == 'B'){
                if(BCnt > 0){
                    BCnt -= 1;
                }
            }else if(input.charAt(l) == 'W'){
                if(WCnt > 0){
                    WCnt -= 1;
                }
            }

        }

        return answer;
    }

}
