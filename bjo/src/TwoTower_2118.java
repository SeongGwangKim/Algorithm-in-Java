import java.io.*;

public class TwoTower_2118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int[] inputArray = new int[N];
        int sumValue = 0;

        for(int i=0; i<N; i++){
            inputArray[i] = Integer.valueOf(br.readLine());
            sumValue += inputArray[i];
        }

        bw.write(searchMinValue(inputArray, sumValue) + "\n");
        bw.flush();

    }

    public static int searchMinValue(int[] inputArray, int sumValue){
        int answer = 0;

        for(int i=0; i<inputArray.length-1; i++){
            // a-b 구역과 그 밖에
            int tempMin = inputArray[i];
            int temp = Math.min(tempMin, sumValue-tempMin);
            answer = Math.max(answer, temp);

            for(int j=i+1; j<inputArray.length-1; j++){
                tempMin += inputArray[j];
                temp = Math.min(tempMin, sumValue-tempMin);
                answer = Math.max(answer, temp);
            }
        }

        return answer;
    }

}
