public class SingleNumberTwo {
    public int singleNumber(int[] nums) {
        int n=nums.length, ones=0,twos=0;
        for(int i=0;i<n;i++){
            ones=(ones^nums[i]) & (~twos);
            twos=(twos^nums[i]) & (~ones);
        }
        return ones;
    }
}
