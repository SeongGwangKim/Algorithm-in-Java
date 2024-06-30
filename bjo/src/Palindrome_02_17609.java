import java.io.*;

public class Palindrome_02_17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.valueOf(br.readLine());
        int answer = 0;

        for(int i=0; i<T; i++){
            String input = br.readLine();

            // 1차 팰린드롬인지 확인
            int l = 0;
            int r = input.length() - 1;

            while(l <= r){
                // 짝이 다른 문자가 나오면 왼쪽이나 오른쪽에서 한 칸 움직였을 때, 팰린드롬인지 확인
                if(input.charAt(l) != input.charAt(r)){
                    // 맞으면 유사회문이므로, 1
                    if(isPalindrome(input, l+1, r) || isPalindrome(input, l, r-1)){
                        answer = 1;
                        break;
                    }else{
                        answer = 2;
                        break;
                    }
                }else{
                    answer = 0;
                }
                l++;
                r--;
            }
            bw.write(answer + "\n");
        }

        bw.flush();

    }

    public static boolean isPalindrome(String input, int l, int r){

        while(l <= r){
            if(input.charAt(l) == input.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
}
