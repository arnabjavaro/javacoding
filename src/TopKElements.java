import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKElements {
    public static int[] KMostFrequent(int a, int k, int[] nums) {
        // Write your code here.
        List<Integer>[] bucket=new List[nums.length+1];
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();

        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        //map looks like
        // 1:4
        // 2:3
        // 5:2
        for(int key: map.keySet()){
            int freq=map.get(key);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        //bucket is prepared now---
        int[] res=new int[k];
        int counter=0;
        for(int i=bucket.length-1; i>=0 && counter<k ; i--){
            if(bucket[i]!=null){
                for(Integer x:bucket[i]) res[counter++]=x;
            }
        }
        return res;
    }
}
