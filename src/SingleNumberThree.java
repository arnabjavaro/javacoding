import java.util.Arrays;

public class SingleNumberThree {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        long xorr=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            xorr=xorr^nums[i];
        }
        // taken from lc solution section rest is taken from striver video
        long rightMostBit= xorr&(xorr*(-1));
        int b1=0,b2=0;
        for(int i=0;i<n;i++){
            if((nums[i]&rightMostBit) !=0) b1=b1^nums[i];
            else b2=b2^nums[i];
        }
        int[] res=new int[2];
        res[0]=b1;
        res[1]=b2;
        return res;
    }
}
