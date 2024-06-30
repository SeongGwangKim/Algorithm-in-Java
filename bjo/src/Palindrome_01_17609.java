import java.io.*;
import java.util.*;

// 홀수 갯수일 때만을 고려하여 일부만 정답
// 홀수가 아닐 때도 존재
public class Palindrome_01_17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.valueOf(br.readLine());

        for(int i=0; i<T; i++){
            String input = br.readLine();
            bw.write(searchPalindrome(input) + "\n");
        }

        bw.flush();

    }

    public static int searchPalindrome(String input){
        int answer = 2;
        int[] checkAlphabet = new int['z' - 'a' + 1];
        HashSet<Character> oddChar = new HashSet<>();

        for(int i=0; i<input.length(); i++){
            checkAlphabet[input.charAt(i) - 'a']++;
        }

        for(int i=0; i<checkAlphabet.length; i++){
            if(checkAlphabet[i] % 2 == 1){
                oddChar.add((char)('a'+i));
            }
        }

        int leftIndex = 0;
        int rightIndex = input.length() - 1;
        int errorCnt = 0;

        while(leftIndex <= rightIndex){
            if(input.charAt(leftIndex) != input.charAt(rightIndex)){
                if(input.charAt(leftIndex + 1) == input.charAt(rightIndex) && oddChar.contains(input.charAt(leftIndex))){
                    leftIndex += 2;
                    rightIndex -= 1;
                    errorCnt++;
                }else if(input.charAt(leftIndex) == input.charAt(rightIndex - 1) && oddChar.contains(input.charAt(rightIndex))){
                    leftIndex += 1;
                    rightIndex -= 2;
                    errorCnt++;
                }else{
                    errorCnt += 2;
                    break;
                }
            }else{
                leftIndex++;
                rightIndex--;
            }

            if(errorCnt > 1){
                answer = 2;
                break;
            }
        }

        if(errorCnt == 0){
            answer = 0;
        }else if(errorCnt == 1){
            answer = 1;
        }

        return answer;
    }
}
