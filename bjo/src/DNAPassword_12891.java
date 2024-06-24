import java.io.*;

public class DNAPassword_12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] SP = br.readLine().split(" ");
        int S = Integer.valueOf(SP[0]);
        int P = Integer.valueOf(SP[1]);
        char[] inputArray = br.readLine().toCharArray();

        String[] tempACGT = br.readLine().split(" ");
        int[] ACGT = new int[4];
        for(int i=0; i<4; i++){
            ACGT[i] = Integer.valueOf(tempACGT[i]);
        }

        bw.write(searchPosiblePassword(inputArray, ACGT, P) + "\n");
        bw.flush();


    }

    public static int searchPosiblePassword(char[] inputArray, int[] ACGT, int P){
        int answer = 0;
        int[] checkACGT = new int[4];
        int rightIndex = 0;

        for(int i=0; i<inputArray.length; i++){
            while(rightIndex - i + 1 <= P && rightIndex < inputArray.length){
                if(inputArray[rightIndex] == 'A'){
                    checkACGT[0]++;
                }else if(inputArray[rightIndex] == 'C'){
                    checkACGT[1]++;
                }else if(inputArray[rightIndex] == 'G'){
                    checkACGT[2]++;
                }else if(inputArray[rightIndex] == 'T'){
                    checkACGT[3]++;
                }

                rightIndex += 1;
            }
            if(i+P > inputArray.length){
                break;
            }

            int temp_cnt = 0;
            for(int j=0; j<ACGT.length; j++){
                if(ACGT[j] <= checkACGT[j]){
                    temp_cnt++;
                }
            }

            if(temp_cnt == 4){
                answer += 1;
            }

            if(inputArray[i] == 'A'){
                checkACGT[0]--;
            }else if(inputArray[i] == 'C'){
                checkACGT[1]--;
            }else if(inputArray[i] == 'G'){
                checkACGT[2]--;
            }else if(inputArray[i] == 'T'){
                checkACGT[3]--;
            }
        }
        

        return answer;
    }

}
