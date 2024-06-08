import java.io.*;

class Sol_ManagingPocketMoney_6236
{
    public static boolean isPossible(int[] inputArray, int m, int M) {
        int cnt = 1;
        int balance = m;

        for (int input : inputArray) {
//            if (input > m){
//                return false;
//            }

            if (balance < input) {
                if (cnt == M) {
                    return false;
                }
                cnt++;
                balance = m;
            }
            balance -= input;
        }

        return true;
    }

    public static int searchOptimalValue(int[] inputArray, int M, int maxMoney, int sumMoney){
        int answer = 0;
        int l = maxMoney;
        int r = sumMoney;

        while (l <= r) {
            int m = (l + r) / 2;
            // 인출 횟수가 적으면 용돈을 줄인다.
            if (isPossible(inputArray, m, M)) {
                answer = m;
                r = m - 1;
            // 인출 횟수가 많으면 용돈을 늘린다.
            }else {
                l = m + 1;
            }
        }

        return answer;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.valueOf(NM[0]);
        int M = Integer.valueOf(NM[1]);

        int[] inputArray = new int[N];
        int maxMoney = 0;
        int sumMoney = 0;

        for(int i=0; i<N; i++){
            inputArray[i] = Integer.valueOf(br.readLine());
            if(maxMoney < inputArray[i]){
                maxMoney = inputArray[i];
            }
            sumMoney += inputArray[i];
        }


        bw.write(searchOptimalValue(inputArray, M, maxMoney, sumMoney) + "\n");
        bw.flush();
    }
}