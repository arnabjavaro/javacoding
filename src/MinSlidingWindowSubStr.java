import java.util.HashMap;
import java.util.Map;

public class MinSlidingWindowSubStr {
    public String minWindow(String s, String t) {
        if(t.equals("")) return "";
        Map<Character,Integer> reqM=new HashMap<>();
        Map<Character,Integer> window=new HashMap<>();

        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            reqM.put(c,reqM.getOrDefault(c,0)+1);
            window.put(c,0);
        }
        int current=0,desired=reqM.size();
        int[] res={-1,-1};
        int resLen=Integer.MAX_VALUE;
        int left=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            if(t.indexOf(ch)!=-1){
                window.put(ch, window.getOrDefault(ch,0)+1);
            }

            if(reqM.containsKey(ch) && reqM.get(ch).equals(window.get(ch))){
                current+=1;
            }

            while(current == desired){
                if((right-left+1)<resLen){
                    res[0]=left;
                    res[1]=right;
                    resLen=right-left+1;
                }

                char lCh=s.charAt(left);
                if(t.indexOf(lCh)!=-1){
                    window.put(lCh, window.get(lCh)-1);
                }

                if(reqM.containsKey(lCh) && reqM.get(lCh) > window.get(lCh)){
                    current-=1;
                }
                left+=1;
            }
        }

        int lInd=res[0],rInd=res[1];
        return resLen != Integer.MAX_VALUE ? s.substring(lInd,rInd+1) : "";
    }
}
