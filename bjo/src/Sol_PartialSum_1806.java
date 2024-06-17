import java.io.*;

// two pointer 사용한 풀이
public class Sol_PartialSum_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NS = br.readLine().split(" ");
        int N = Integer.valueOf(NS[0]);
        int S = Integer.valueOf(NS[1]);

        String[] tempArray = br.readLine().split(" ");
        int[] inputArray = new int[N];

        for(int i=0; i<N; i++){
            inputArray[i] = Integer.valueOf(tempArray[i]);
        }

        bw.write(searchValue(inputArray, S) + "\n");
        bw.flush();


    }

    public static int searchValue(int[] inputArray, int S){
        int answer = inputArray.length+1;
        int rightIndex = 0;
        int currentSum = inputArray[0];

        for(int i=0; i<inputArray.length; i++){
            while(currentSum < S && rightIndex < inputArray.length-1){
                currentSum += inputArray[++rightIndex];
            }

            if(currentSum >= S){
                answer = Math.min(answer, rightIndex - i +1);
            }

            currentSum -= inputArray[i];

        }

        if(answer > inputArray.length){
            answer = 0;
        }

        return answer;
    }

}
