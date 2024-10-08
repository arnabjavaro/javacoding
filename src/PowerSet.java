import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        int subsets=1<<n;
        List<List<Integer>> res=new ArrayList<>();

        for(int num=0;num<=subsets-1;num++){
            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<n;i++){
                if((num & (1<<i))!=0){
                    ans.add(nums[i]);
                }
            }
            res.add(ans);
        }
        return res;
    }
}
