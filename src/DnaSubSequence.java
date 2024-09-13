import java.util.*;
import java.util.stream.Collectors;

public class DnaSubSequence {

    public List<String> findRepeatedDnaSequences(String s) {
        int k=10;
        int n=s.length();
        List<String> empty=new ArrayList<>();
        if(n<k) return empty;
        Set<Character> uniqueChars= s.chars().mapToObj(c-> (char)c).collect(Collectors.toSet());
        Map<Character,Integer> hmap=new HashMap<>();
        int cnt=1;
        for(Character ch: uniqueChars){
            hmap.put(ch,cnt);
            cnt++;
        }

        int baseValue=uniqueChars.size();
        List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[n]));
        Arrays.fill(numbers.toArray(),0);
        for(int i=0;i<n;i++){
            numbers.set(i,hmap.get(s.charAt(i)));
        }

        int hashVal=0;
        Set<Integer> hashSet = new HashSet<>();
        Set<String> output = new HashSet<>();
        for(int i=0;i<n-k+1;i++){
            if(i==0){
                for(int j=0;j<k;j++){
                    hashVal+= numbers.get(j)* (int) Math.pow(baseValue,k-j-1);
                }
            }else{
                int prevVal=hashVal;
                hashVal = ((prevVal- numbers.get(i-1) * (int)Math.pow(baseValue,k-1))*baseValue) + numbers.get(i+k-1);
            }

            if(hashSet.contains(hashVal)){
                output.add(s.substring(i,i+k));
            }
            hashSet.add(hashVal);
        }
        List<String> stringList = new ArrayList<>(output);
        return stringList;
    }
}
