import java.io.*;
import java.util.*;

public class Cat_01_16472 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        String input = br.readLine();

        bw.write(searchMaxLength(input, N) + "\n");
        bw.flush();

    }

    public static int searchMaxLength(String input, int N){
        int answer = 0;
        TreeMap<Character, Integer> charMap = new TreeMap<>();
        int r = 0;
        int len = 0;

        for(int l=0; l<input.length(); l++){
            while(r < input.length() && charMap.size() <= N){
                char tempR = input.charAt(r);
                if(charMap.containsKey(tempR)){
                    charMap.put(tempR, charMap.get(tempR)+1);
                }else{
                    charMap.put(tempR, 1);
                }

                if(charMap.size() > N){
                    charMap.put(tempR, charMap.get(tempR)-1);
                    break;
                }

                len += 1;
                r += 1;

            }

            answer = Math.max(answer, len);

            char tempL = input.charAt(l);
            if(charMap.containsKey(tempL)){
                charMap.put(tempL, charMap.get(tempL)-1);
                len -= 1;
            }

            if(charMap.get(tempL) == 0){
                charMap.remove(tempL);
            }

        }

        return answer;
    }
}
