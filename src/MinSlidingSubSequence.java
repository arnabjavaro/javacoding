public class MinSlidingSubSequence {
    public static String minWindow(String s, String t) {
        // Write your code here
        int inds1=0,inds2=0;
        int sizes1=s.length(),sizes2=t.length();
        int start=0,end=0;
        float minLength=Float.POSITIVE_INFINITY;
        String minsubSeq="";

        while(inds1<sizes1){
            if(s.charAt(inds1)==t.charAt(inds2)){
                inds2+=1;
                if(inds2==sizes2){
                    //backward movement starts
                    start=inds1;
                    end=inds1;
                    inds2-=1;
                    while(inds2>=0){
                        if(s.charAt(start)==t.charAt(inds2)){
                            inds2-=1;
                        }
                        start-=1;
                    }
                    start+=1;
                    if(minLength>(end-start+1)){
                        minLength=end-start+1;
                        minsubSeq=s.substring(start,end+1);
                    }
                    //after taking minsubsequence setting inds1 and inds2 for next iteration
                    inds1=start;
                    inds2=0;
                }
            }
            inds1++;
        }
        return minsubSeq;

    }
}
