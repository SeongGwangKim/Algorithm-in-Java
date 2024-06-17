import java.io.*;

public class PartialSum_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NS = br.readLine().split(" ");
        int N = Integer.valueOf(NS[0]);
        int S = Integer.valueOf(NS[1]);

        String[] tempArray = br.readLine().split(" ");
        long[] sumArray = new long[N+1];
        int tempSum = 0;
        sumArray[0] = 0;

        for(int i=0; i<N; i++){
            tempSum += Integer.valueOf(tempArray[i]);
            sumArray[i+1] = tempSum;
        }

        bw.write(searchValue(sumArray, S) + "\n");
        bw.flush();


    }

    // 부분합 + Bineary Search
    public static int searchValue(long[] sumArray, int S){
        int answer = sumArray.length+1;

        for(int i=1; i<sumArray.length; i++){
            int l = i;
            int r = sumArray.length -1;

            while(l <= r){
                int m = (l+r)/2;
                long temp = sumArray[m] - sumArray[i-1];

                if(temp >= S){
                    answer = Math.min(answer, m - i + 1);
                    r = m - 1;
                }else{
                    l = m + 1;
                }

            }
        }

        if(answer > sumArray.length){
            answer = 0;
        }

        return answer;
    }

    // 탐욕법을 활용한 풀이 -> 시간 초과
    public static int searchValue_01(long[] sumArray, int S){
        int answer = sumArray.length+1;

        for(int i=sumArray.length-1; i>=0; i--){
            for(int j=i-1; j>=0; j--){
                long temp = sumArray[i] - sumArray[j];
                if(temp >= S){
                    if(answer > i - j){
                        answer = i - j ;
                    }
                }
            }
        }

        if(answer > sumArray.length){
            answer = 0;
        }

        return answer;
    }

}
