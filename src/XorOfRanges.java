public class XorOfRanges {
    public static int calculateXOR(int n) {
        // Write your code here.
        if(n%4==1) return 1;
        else if(n%4==2) return n+1;
        else if(n%4==3) return 0;
        else return n;
    }
}
