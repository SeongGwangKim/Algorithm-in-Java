import java.io.*;

public class Cat_02_16472 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        String inputString = br.readLine();

        bw.write(getMaxLength(inputString, N) + "\n");
        bw.flush();

    }

    public static int getAlphabetCount(int[] alphabetCountArray){
        int alphabetCount = 0;

        for(int i=0; i<alphabetCountArray.length; i++){
            if(alphabetCountArray[i] > 0){
                alphabetCount += 1;
            }
        }

        return alphabetCount;
    }

    public static int getMaxLength(String inputString, int N){
        int answer = 0;
        int r = 0;
        int[] alphabetCountArray = new int['z'-'a'+1];
        int length = 0;

        for(int l=0; l<inputString.length(); l++){
            while(r < inputString.length()){
                alphabetCountArray[inputString.charAt(r) - 'a'] += 1;
                if(getAlphabetCount(alphabetCountArray) > N){
                    alphabetCountArray[inputString.charAt(r) - 'a'] -= 1;
                    break;
                }else{
                    length += 1;
                    r += 1;
                }

            }
            answer = Math.max(answer, length);

            if(alphabetCountArray[inputString.charAt(l) - 'a'] > 0){
                alphabetCountArray[inputString.charAt(l) - 'a'] -= 1;
            }
            length -= 1;

        }

        return answer;
    }

}
