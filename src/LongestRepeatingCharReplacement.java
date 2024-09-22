import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharReplacement {
    public static int longestRepeatingSubstring(String s, int k) {
        // Write your code here.
        int start=0;
        Map<Character,Integer> charFreq=new HashMap<>();
        int maxRepeatChar=0,maxLenSubSeq=0;

        for(int end=0;end<s.length();end++){
            char ch=s.charAt(end);
            charFreq.put(ch,charFreq.getOrDefault(ch,0)+1);
            maxRepeatChar = Math.max(charFreq.get(ch),maxRepeatChar);

            if(end-start+1-maxRepeatChar > k){
                charFreq.put(s.charAt(start),charFreq.get(s.charAt(start))-1);
                start+=1;
            }

            maxLenSubSeq = Math.max(maxLenSubSeq,end-start+1);
        }

        return maxLenSubSeq;
    }
}
