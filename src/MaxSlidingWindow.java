import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==1) return nums;
        int n=nums.length;
        int[] output=new int[n-k+1];
        Deque<Integer> dq=new ArrayDeque<>();

        for(int i=0;i<k;i++){
            cleanUp(nums,dq,i);
            dq.add(i);
        }
        output[0]=nums[dq.getFirst()];

        for(int i=k;i<n;i++){
            cleanUp(nums,dq,i);

            while(!dq.isEmpty() && dq.getFirst()<=(i-k)){
                dq.removeFirst();
            }

            dq.add(i);
            output[i-k+1]=nums[dq.getFirst()];
        }

        return output;

    }

    public Deque<Integer> cleanUp(int[] nums,Deque<Integer> dq,int i){
        while(dq.size()!=0 && nums[i]>=nums[dq.getLast()]){
            dq.removeLast();
        }
        return dq;
    }
}
