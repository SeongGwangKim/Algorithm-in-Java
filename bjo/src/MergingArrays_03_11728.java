import java.io.*;
import java.util.*;

// TreeMap을 활용한 풀이
public class MergingArrays_03_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.valueOf(NM[0]);
        int M = Integer.valueOf(NM[1]);

        String[] NArray = br.readLine().split(" ");
        String[] MArray = br.readLine().split(" ");

        TreeMap<Integer, Integer> answerMap = new TreeMap<>();
        for(int i=0; i<N; i++){
            if(answerMap.containsKey(Integer.valueOf(NArray[i]))){
                answerMap.put(Integer.valueOf(NArray[i]), answerMap.get(Integer.valueOf(NArray[i]))+1);
            }else{
                answerMap.put(Integer.valueOf(NArray[i]), 1);
            }

        }

        for(int i=0; i<M; i++){
            if(answerMap.containsKey(Integer.valueOf(MArray[i]))){
                answerMap.put(Integer.valueOf(MArray[i]), answerMap.get(Integer.valueOf(MArray[i]))+1);
            }else{
                answerMap.put(Integer.valueOf(MArray[i]), 1);
            }

        }
        Integer[] keySet =  answerMap.keySet().toArray(new Integer[answerMap.size()]);
        for(Integer key : keySet){
            for(int i=0; i<answerMap.get(key); i++){
                bw.write(key + " ");
            }
        }
        bw.flush();
    }
}
